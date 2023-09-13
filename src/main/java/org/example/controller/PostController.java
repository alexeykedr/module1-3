package org.example.controller;

import org.example.model.Post;
import org.example.repository.PostRepository;
import org.example.repository.gsonImpl.GsonPostRepositoryImpl;

import java.time.LocalDateTime;
import java.util.List;

public class PostController {
    private final PostRepository postRepository = new GsonPostRepositoryImpl();

    public Post createPost(String content) {
        Post post = new Post(0, content);
        return postRepository.create(post);
    }

    public Post updatePostById(Integer id, String content) {
        Post post = new Post(id, content);
        post.setContent(content);
        post.setUpdated(LocalDateTime.now());
        return postRepository.updateById(post);
    }
    public Post getPostById(Integer id){
        return postRepository.getById(id);
    }
    public List<Post> getAll() {
        return postRepository.getAll();
    }
    public void deletePostById(Integer id){
        postRepository.getById(id);
    }
}
