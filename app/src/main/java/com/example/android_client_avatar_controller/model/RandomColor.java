/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.example.android_client_avatar_controller.model;

public class RandomColor {

    private String type = "RandomColor";

    // -------------------------------------
    // Attributtes
    // -------------------------------------
    private String id;
    private int r;
    private int g;
    private int b;
    private String description;

    // -------------------------------------
    // Constructors
    // -------------------------------------
    public RandomColor() {

    }

    public RandomColor(String id, int r, int g, int b, String description) {

        this.id = id;
        this.r = r;
        this.g = g;
        this.b = b;
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

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
