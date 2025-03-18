package com.example.testetcc.interfaces;

import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Update;

import com.example.testetcc.model.Usuario;

import java.util.List;

// Interface com todos os metodos que irao interagir com o Banco de Dados
public interface UsuarioDAO<User> {

    //Retorna todos os usuarios
    @Query("SELECT * FROM Usuarios")
    Usuario [] loadAllUsers();

    //Retorna todos os id's dos Usuarios
    @Query("SELECT * FROM Usuarios WHERE id IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    //Retorna os usuarios por seus apelidos
    @Query("SELECT * FROM Usuarios WHERE apelido ")
    List<User> loadAllapelido(String apelido);

    //Retorna o email de c ada usuario
    @Query("SELECT * FROM Usuarios WHERE email")
    List<User> loadALLemail(String email);

    //Atualiza o Usuario
    @Update
    void Update(Usuario usuario);

    // Exclui o um Usuario
    @Delete
    void delete(User user);
}

