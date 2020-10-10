/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.example.android_client_avatar_controller.model;

public class Name {

    private String type = "Name";

    // -------------------------------------
    // Attributtes
    // -------------------------------------
    private String id;
    private String name;
    private String description;

    // -------------------------------------
    // Constructor
    // -------------------------------------
    public Name() {

    }

    public Name(String id, String name, String description) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
