package org.example.model;

public class Label {
    private  int id;
    private  String name;
    private Status status;

    public Label(int id, String nameLabel) {
        this.id = id;
        this.name = nameLabel;
        status = Status.ACTIVE;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
