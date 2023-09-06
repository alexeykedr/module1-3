package org.example.controller;

import org.example.model.Post;

import java.util.List;

public interface PostController {

    List<Post> createPostUser(String content);

    Post getPost(int id);


    void updatePost(int id, String content);

    void deletePost(int id);



}
