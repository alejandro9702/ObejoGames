package com.test.andresf.ObejoGames.modelo;

/**
 * Created by Next University.
 */
public class ListItem {

    private String titulo;
    private String subtitulo;
    private int imagen;

    public ListItem(String titulo, String subtitulo, int imagen) {
        this.subtitulo = subtitulo;
        this.titulo = titulo;
        this.imagen = imagen;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
