package org.example.view;

import org.example.controller.PostController;
import org.example.model.Post;

import java.util.List;
import java.util.Scanner;

public class PostView {
    private final PostController postController = new PostController();
    private final Scanner scanner = new Scanner(System.in);


    public void createPost() {
        System.out.println("Enter content");

        String content = scanner.nextLine();
        Post createPost = postController.createPost(content);
        System.out.println(createPost);
        System.out.println("Post " + createPost + " created!");

    }

    public void updatePostById()  {
        System.out.println("Enter id");
        Integer id = scanner.nextInt();
        System.out.println("Enter content");
        String content = scanner.nextLine();

        Post updatePost = postController.updatePostById(id, content);
        System.out.println("Post " + updatePost + " updated");
    }

    public void getPostById() {
        System.out.println("Enter id:");

        Integer id = scanner.nextInt();
        Post post = postController.getPostById(id);
        System.out.println("Label " + post);
    }

    public List<Post> getAllPosts() {
        List<Post> posts = postController.getAll();
        System.out.println(posts);
        return posts;
    }

    public void deletePostById() {
        System.out.println("Enter id:");

        Integer id = scanner.nextInt();
        postController.deletePostById(id);
        System.out.println("Post deleted!");
    }
}
