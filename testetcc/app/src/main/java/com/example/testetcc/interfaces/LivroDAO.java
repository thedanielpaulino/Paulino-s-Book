package com.example.testetcc.interfaces;

import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Update;

import com.example.testetcc.model.Livro;
import com.example.testetcc.model.Usuario;

import java.util.List;

// Interface com todos os metodos que irao interagir com o Banco de Dados
public interface LivroDAO<User> {

    //Retorna todos os usuarios
    @Query("SELECT * FROM livro")
    Usuario [] loadAllUsers();

    //Retorna todos os id's dos Usuarios
    @Query("SELECT * FROM livro WHERE id_livro IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    //Retorna os usuarios por seus apelidos
    @Query("SELECT * FROM livro WHERE escritor ")
    List<User> loadAllescritor(String escritor);

    //Retorna o email de cada usuario
    @Query("SELECT * FROM livro WHERE tema")
    List<User> loadALLtema(String tema);

    @Query("SELECT * FROM livro WHERE titulo")
    List<User> loadALLtitulo(String titulo);

    @Query("SELECT * FROM livro WHERE idioma")
    List<User> loadALLidioma(String idioma);

    //Atualiza o Usuario
    @Update
    void Update(Livro livro);

    @Delete
    void delete(User user);

    void inserir(Livro novoLivro);

    List<Livro> getTodosLivros();
}

