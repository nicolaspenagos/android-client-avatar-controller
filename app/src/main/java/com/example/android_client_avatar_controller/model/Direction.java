/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.example.android_client_avatar_controller.model;

public class Direction {

    private String type = "Direction";

    // -------------------------------------
    // Atributtes
    // -------------------------------------
    private String id;
    private Dirs direction;
    private String description;

    // -------------------------------------
    // Constructors
    // -------------------------------------
    public Direction() {

    }

    public Direction(String id, Dirs direction, String description) {
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

    public Dirs getDirection() {
        return direction;
    }

    public void setDirection(Dirs direction) {
        this.direction = direction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
