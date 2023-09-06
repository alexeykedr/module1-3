package org.example.model;

public class Label {
    private  int id = 0;
    private  String name = "";
    private PostStatus status = PostStatus.ACTIVE;

    public Label(int id, String nameLabel) {
        this.id = id;
        this.name = nameLabel;
        status = PostStatus.ACTIVE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }
}
