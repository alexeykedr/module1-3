package org.example.repository.gsonImpl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.Post;
import org.example.model.Status;
import org.example.repository.PostRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GsonPostRepositoryImpl implements PostRepository {

    private final String FILE_PATH = "src/main/resources/posts.json";
    private final Gson GSON = new Gson();

        private List<Post> getAllItems() {
        List<Post> listPost = new ArrayList<>();
        return readerPostsFromJson(listPost);
    }

    private void writeAllItems(List<Post> posts) {
        writerPostsToJson(posts);
    }
    @Override
    public List<Post> getAll() {
        return getAllItems();
    }


    @Override
    public Post create(Post postToCreate) {
        List<Post> posts = getAllItems();
        Integer id = generateID(posts);

        posts.add(postToCreate);
        return postToCreate;
    }



    @Override
    public Post getById(Integer id) {
       return getAllItems().stream()
               .filter(item ->
                       item.getId() == id
               ).findFirst()
               .orElse(null);
    }


    @Override
    public Post updateById(Post postToUpdate) {

        List<Post> postListInner = getAllItems().stream()
                .map(existingPost -> {

                    if (existingPost.getId() == postToUpdate.getId()) {
                   return postToUpdate;
                    }
                    return existingPost;
                }).collect(Collectors.toList());

        writeAllItems(postListInner);
        //почему возвращаем postToUpdate а не postListInner?
        return postToUpdate;
    }


    @Override
    public void deleteById(Integer id) {
        List<Post> postListInner = getAllItems().stream()
                .map(p -> {
                    if (p.getId() == id) {
                        p.setStatus(Status.DELETED);
                    }
                    return p;
                        }).collect(Collectors.toList());
writeAllItems(postListInner);
    }


    private Integer generateID(List<Post> posts) {
        return posts.stream()
                .mapToInt(Post::getId)
                .max().orElse(0) + 1;
    }

    private void writerPostsToJson(List<Post> listElement) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(GSON.toJson(listElement));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e + "Exception writing of posts.json FNFEx");
        } catch (IOException e) {
            throw new RuntimeException(e + "Exception writing of posts.json IOEx");
        }
    }

    private List<Post> readerPostsFromJson(List<Post> listElement) {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Post>>() {
            }.getType();
            List<Post> result = GSON.fromJson(reader, listType);
            listElement.addAll(result);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e + "Exception reading of posts.json FNFEx");
        } catch (IOException e) {
            throw new RuntimeException(e + "Exception reading of posts.json IOEx");
        }
        return listElement;
    }


}
    
    


    

