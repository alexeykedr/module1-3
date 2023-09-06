package org.example.repository;

import org.example.model.Post;

import java.util.List;

public interface PostRepository extends GenericRepository<Post, Integer> {
    List<Post> createPost(String content);

    Post getPostById(int id);


    void updatePostById(int id, String content);

    void deletePostById(int id);

     List<Post> readerCollection(List<Post> listElement);

     void writerCollection(List<Post> listElement);
}
