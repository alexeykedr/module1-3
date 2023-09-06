package org.example.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.Label;
import org.example.model.Post;
import org.example.model.PostStatus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GsonPostRepositoryImpl implements PostRepository {
    List<Post> postsList = new ArrayList<>();
    List<Label> labels = new ArrayList<>();
    private int id = 1;
    public static String FILENAME = "posts.json";
    Gson gson = new Gson();

    @Override
    public List<Post> create(String content) {
        Post post = new Post(id++,
                content,
                LocalDateTime.now(),
                labels,
                PostStatus.ACTIVE);

        postsList.add(post);
        writerCollection(postsList);
        return postsList;
    }


    @Override
    public Post getById(Integer id) {
        List<Post> postListInner = readerCollection(postsList);

        return postListInner.stream()
                .filter(post -> id == post.getId())
                .findFirst()
                .orElse(null);
    }


    @Override
    public void updateById(Integer id, String content) {
        List<Post> postListInner = readerCollection(postsList);

        List<Post> postListFiltered = postListInner.stream()
                .filter(post -> id == post.getId())
                .map(post -> {
                    post.setContent(content);
                    post.setUpdated(LocalDateTime.now());
                    return post;
                })
                .collect(Collectors.toList());

        writerCollection(postListFiltered);

    }


@Override
public void deleteById(Integer id) {
    List<Post> postListInner = readerCollection(postsList);

    List<Post> postListFiltered = postListInner.stream()
            .filter(post -> id == post.getId())
            .map(post -> {
                post.setStatus(PostStatus.DELETED);
                post.setUpdated(LocalDateTime.now());
                return post;
            })
            .collect(Collectors.toList());

    writerCollection(postListFiltered);
}



    private void writerCollection(List<Post> listElement) {
        try (FileWriter writer = new FileWriter(FILENAME)) {
            writer.write(gson.toJson(listElement));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e + "Exception writing of posts.json FNFEx");
        } catch (IOException e) {
            throw new RuntimeException(e + "Exception writing of posts.json IOEx");
        }
    }

    private List<Post> readerCollection(List<Post> listElement) {
        try (FileReader reader = new FileReader(FILENAME)) {
            Type listType = new TypeToken<ArrayList<Post>>() {
            }.getType();
            List<Post> result = gson.fromJson(reader, listType);
            listElement.addAll(result);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e + "Exception reading of posts.json FNFEx");
        } catch (IOException e) {
            throw new RuntimeException(e + "Exception reading of posts.json IOEx");
        }
        return listElement;
    }
}
    
    


    

