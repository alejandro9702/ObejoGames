package com.test.andresf.ObejoGames;

/**
 * Created by AndresF on 19/12/2016.
 */

import java.io.Serializable;

public class sesion implements Serializable {
    private String name;
    private String email;

    private String id;
    private int image;


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

    public String getDescripcion() {
        return email;
    }
    public void setDescripcion(String descripcion) {
        this.email = descripcion;
    }

    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }


}
