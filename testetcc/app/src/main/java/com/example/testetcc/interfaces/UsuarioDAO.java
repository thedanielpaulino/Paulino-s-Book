package com.example.testetcc.interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.testetcc.model.Usuario;

import java.util.List;


// Interface com todos os metodos que irao interagir com o Banco de Dados
@Dao
public interface UsuarioDAO {

    //Retorna todos os usuarios
    @Query("SELECT * FROM usuarios")
    Usuario[] loadAllUsers();

    //Retorna todos os id's dos Usuarios
    @Query("SELECT * FROM Usuarios WHERE id IN (:userIds)")
    List<Usuario> loadAllByIds(int[] userIds);

    //Retorna os usuarios por seus apelidos

    @Query("SELECT * FROM usuarios WHERE email = :email AND senha = :senha LIMIT 1")
    Usuario login(String email, String senha);
    @Query("SELECT * FROM Usuarios WHERE apelido = :apelido ")
    List<Usuario> loadAllApelido(String apelido);

    //Retorna o email de c ada usuario
    @Query("SELECT * FROM Usuarios WHERE email = :email")
    List<Usuario> loadALLEmail(String email);

    @Query("SELECT * FROM Usuarios WHERE senha = :senha")
    List<Usuario> loadALLSenha(String senha);

    //Atualiza o Usuario
    @Update
    void update(Usuario usuario);

    // Exclui o um Usuario

    @Insert
    void inserir(Usuario usuario);
    @Delete
    void delete(Usuario usuario);
}

