package com.example.testetcc.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.Room;

import com.example.testetcc.interfaces.LivroDAO;
import com.example.testetcc.interfaces.UsuarioDAO;
import com.example.testetcc.model.Livro;
import com.example.testetcc.model.Usuario;

@Database(entities = {Usuario.class, Livro.class}, version = 2) // 🚨 Alterando a versão do banco!
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instancia;

    public abstract UsuarioDAO usuarioDao();
    public abstract LivroDAO livroDao(); // Adicionando DAO do Livro

    public static synchronized AppDatabase getInstance(Context context) {
        if (instancia == null) {
            instancia = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "paulinosbook.db")
                    .fallbackToDestructiveMigration() // Permite recriar DB ao mudar versão
                    .allowMainThreadQueries() // NÃO recomendado para produção
                    .build();
        }
        return instancia;
    }
}
