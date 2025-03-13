package com.example.testetcc.model;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "livro")
public class Livro {
    @PrimaryKey(autoGenerate = true)
    private int idlivro;
    private String escritor;
    private String sinopse;
    private String titulo;
    private String idioma;

    public Livro(String escritor, String sinopse, String titulo, String idioma) {
        this.escritor = escritor;
        this.sinopse = sinopse;
        this.titulo = titulo;
        this.idioma = idioma;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public int getIdlivro() {
        return idlivro;
    }

    public void setIdlivro(int idlivro) {
        this.idlivro = idlivro;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
