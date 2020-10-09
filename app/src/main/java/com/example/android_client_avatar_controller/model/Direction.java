package com.example.android_client_avatar_controller.model;

public class Direction {

    // -------------------------------------
    // Atributtes
    // -------------------------------------
    private String id;
    private int direction;
    private String description;

    // -------------------------------------
    // Constructors
    // -------------------------------------
    public Direction() {

    }

    public Direction(String id, int direction, String description) {
        this.id = id;
        this.direction = direction;
        this.description = description;
    }

    // -------------------------------------
    // Getters and setters
    // -------------------------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
