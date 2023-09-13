package org.example.repository.gsonImpl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.Label;
import org.example.model.Status;
import org.example.repository.LabelRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GsonLabelRepositoryImpl implements LabelRepository {

    private final String FILE_PATH = "src/main/resources/labels.json";
    private final Gson GSON = new Gson();

    private List<Label> getAllItems() {
        List<Label> listLabel = new ArrayList<>();
        return readerLabelsFromJson(listLabel);
    }

    private void writeAllItems(List<Label> labels) {
        writerLabelsToJson(labels);
    }

    @Override
    public List<Label> getAll() {
        return getAllItems();
    }

    @Override
    public Label create(Label labelToCreate) {
        List<Label> labels = getAllItems();
        Integer id = generateID(labels);

        labels.add(labelToCreate);
        return labelToCreate;

    }

    @Override
    public Label getById(Integer id) {
        return getAllItems().stream()
                .filter(item ->
                        item.getId() == id
                ).findFirst()
                .orElse(null);

    }

    @Override
    public Label updateById(Label labelToUpdate) {
        List<Label> labels = getAllItems().stream()
                .map(existingLabel -> {
                    if (existingLabel.getId() == labelToUpdate.getId()) {
                        return labelToUpdate;
                    }
                    return existingLabel;
                }).collect(Collectors.toList());

        writeAllItems(labels);
        return labelToUpdate;
    }




    @Override
    public void deleteById(Integer id) {
        List<Label> labels = getAllItems().stream()
                .map(l -> {
                    if (l.getId() == id) {
                        l.setStatus(Status.DELETED);
                    }
                    return l;
                }).collect(Collectors.toList());

        writeAllItems(labels);

    }

    private Integer generateID(List<Label> labels) {
        return labels.stream()
                .mapToInt(Label::getId)
                .max().orElse(0) + 1;
    }

    private void writerLabelsToJson(List<Label> listElement) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(GSON.toJson(listElement));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e + "Exception writing of labels.json FNFEx");
        } catch (IOException e) {
            throw new RuntimeException(e + "Exception writing of labels.json IOEx");
        }
    }

    private List<Label> readerLabelsFromJson(List<Label> listElement) {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Label>>() {
            }.getType();
            List<Label> result = GSON.fromJson(reader, listType);
            listElement.addAll(result);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e + "Exception reading of labels.json FNFEx");
        } catch (IOException e) {
            throw new RuntimeException(e + "Exception reading of labels.json IOEx");
        }
        return listElement;
    }
}
