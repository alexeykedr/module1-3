package org.example.controller;

import org.example.model.Post;
import org.example.repository.GsonPostRepositoryImpl;
import java.util.List;



public class PostControllerImpl implements PostController {
    GsonPostRepositoryImpl gsonPostRepository = new GsonPostRepositoryImpl();


    @Override
    public List<Post> createPostUser(String content) {
        return gsonPostRepository.create(content);
    }

    @Override
    public Post getPost(int id) {
        return gsonPostRepository.getById(id);

    }

    @Override
    public void updatePost(int id, String content) {
        gsonPostRepository.updateById(id, content);
    }

    @Override
    public void deletePost(int id) {
        gsonPostRepository.deleteById(id);

    }

}




