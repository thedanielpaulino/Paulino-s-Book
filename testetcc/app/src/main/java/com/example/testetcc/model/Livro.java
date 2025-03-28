package com.example.testetcc.model;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
    @Entity(tableName = "livro")
        public class Livro {
    @PrimaryKey(autoGenerate = true)
            private int id_livro;
    @ColumnInfo(name = "escritor")
        private String escritor;
    @ColumnInfo(name = "tema")
        private String tema;
    @ColumnInfo(name = "titulo")
        private String titulo;
    @ColumnInfo(name = "idioma")
        private String idioma;
    public Livro(String escritor, String tema, String titulo, String idioma) {
        this.escritor = escritor;
        this.tema = tema;
        this.titulo = titulo;
        this.idioma = idioma;
    }
    //Getters e Setters
    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
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
