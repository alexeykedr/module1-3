package org.example.repository.gsonImpl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.Status;
import org.example.model.Writer;
import org.example.repository.WriterRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GsonWriterRepositoryImpl implements WriterRepository {

    private final String FILE_PATH = "src/main/resources/writers.json";
    private final Gson GSON = new Gson();

    private List<Writer> getAllItems() {
        List<Writer> listWriter = new ArrayList<>();
        return readerWritersFromJson(listWriter);
    }

    private void writeAllItems(List<Writer> writers) {
        writerWritersToJson(writers);
    }
    private Integer generateID(List<Writer> writers) {
        return writers.stream()
                .mapToInt(Writer::getId)
                .max().orElse(0) + 1;
    }
    @Override
    public List<Writer> getAll(Writer writer) {
        return getAllItems();
    }



    @Override
    public Writer create(Writer writerToCreate) {
        List<Writer> writers = getAllItems();
        Integer id = generateID(writers);

        writers.add(writerToCreate);
        return null;
    }




    @Override
    public Writer getById(Integer id) {
        return getAllItems().stream()
                .filter(item ->
                        item.getId() == id
                ).findFirst()
                .orElse(null);
    }




    @Override
    public Writer update(Writer writerToUpdate) {
        List<Writer> writerListInner = getAllItems().stream()
                .map(existingWriter -> {
                    if (existingWriter.getId() == writerToUpdate.getId()) {
                        return writerToUpdate;
                    }
                    return existingWriter;

                }).collect(Collectors.toList());

        writeAllItems(writerListInner);
        return writerToUpdate;
    }


    @Override
    public void deleteById(Integer id) {
        List<Writer> writers = getAllItems().stream()
                .map(w -> {
                    if (w.getId() == id) {
                        w.setStatus(Status.DELETED);
                    }
                    return w;
                }).collect(Collectors.toList());
        writeAllItems(writers);
    }


    private void writerWritersToJson(List<Writer> listElement) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(GSON.toJson(listElement));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e + "Exception writing of writers.json  FNFEx");
        } catch (IOException e) {
            throw new RuntimeException(e + "Exception writing of writers.json  IOEx");
        }
    }

    private List<Writer> readerWritersFromJson(List<Writer> listElement) {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Writer>>() {
            }.getType();
            List<Writer> result = GSON.fromJson(reader, listType);
            listElement.addAll(result);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e + "Exception reading of writers.json FNFEx");
        } catch (IOException e) {
            throw new RuntimeException(e + "Exception reading of writers.json IOEx");
        }
        return listElement;
    }


}






