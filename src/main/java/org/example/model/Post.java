package org.example.model;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
    private int id;
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;
    private List<Post> posts;
    private Status status;

    //for create method
    public Post(int id,
                String content,
                LocalDateTime created,
                List<Post> posts,
                Status status) {
        this.id = id;
        this.content = content;
        this.created = created;
//        this.updated = updated;
        this.posts = posts;
        this.status = status;
    }

    public Post() {
    }

    public Post(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {

        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        updated = LocalDateTime.now();
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public List<Post> getLabels() {
        return posts;
    }

    public void setLabels(List<Post> posts) {
        this.posts = posts;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", posts=" + posts +
                ", status=" + status +
                '}';
    }
}
