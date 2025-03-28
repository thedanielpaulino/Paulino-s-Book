package com.example.testetcc.interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.testetcc.model.Livro;
import com.example.testetcc.model.Usuario;

import java.util.List;

// Interface com todos os metodos que irao interagir com o Banco de Dados
@Dao
public interface LivroDAO {

    @Query("SELECT * FROM livro")
    Livro [] loadAllUsers();

    //Retorna todos os id's dos Usuarios
    @Query("SELECT * FROM livro WHERE id_livro IN (:userIds)")
    List<Livro> loadAllByIds(int[] userIds);

    //Retorna os usuarios por seus apelidos
    @Query("SELECT * FROM livro WHERE escritor = :escritor")
    List<Livro> loadAllescritor(String escritor);

    //Retorna o email de cada usuario
    @Query("SELECT * FROM livro WHERE tema = :tema")
    List<Livro> loadALLtema(String tema);

    @Query("SELECT * FROM livro WHERE titulo = :titulo")
    List<Livro> loadALLtitulo(String titulo);

    @Query("SELECT * FROM livro WHERE idioma = :idioma")
    List<Livro> loadALLidioma(String idioma);

    //Atualiza o Usuario
    @Update
    void update(Livro livro);

    @Delete
    void delete(Livro livro);

    @Insert
    void inserir(Livro novoLivro);

    @Query("SELECT * FROM livro")
    List<Livro> getTodosLivros();
}

