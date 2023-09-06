package org.example.controller;

import org.example.model.Post;
import org.example.repository.GsonPostRepositoryImpl;
import java.util.List;



public class PostControllerImpl implements PostController {
    GsonPostRepositoryImpl gsonPostRepository = new GsonPostRepositoryImpl();


    @Override
    public List<Post> createPostUser(String content) {
        return gsonPostRepository.createPost(content);
    }

    @Override
    public Post getPost(int id) {
        return gsonPostRepository.getPostById(id);

    }

    @Override
    public void updatePost(int id, String content) {
        gsonPostRepository.updatePostById(id, content);
    }

    @Override
    public void deletePost(int id) {
        gsonPostRepository.deletePostById(id);

    }

}




