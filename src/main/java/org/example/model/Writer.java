//import
package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Writer {
    private int id = 0;
    private String firstName = "";
    private String lastName = "";
    private List<Post> posts = new ArrayList<>();
    private PostStatus status = PostStatus.ACTIVE;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }
}
