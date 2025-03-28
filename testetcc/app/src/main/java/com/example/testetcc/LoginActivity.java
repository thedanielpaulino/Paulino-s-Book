package com.example.testetcc;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testetcc.database.AppDatabase;
import com.example.testetcc.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etSenha;
    private Button btnLogin, btnCadastro;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        btnLogin = findViewById(R.id.btnLogin);
        btnCadastro = findViewById(R.id.btnCadastro);
        db = AppDatabase.getInstance(this);

        // Lógica para login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();  // Email do usuário
                String senha = etSenha.getText().toString();  // Senha do usuário

                if (email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Executa o login em segundo plano
                new LoginTask().execute(email, senha);
            }
        });

        // Lógica para cadastro
        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vai para a tela de cadastro
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });
    }

    // Classe AsyncTask para realizar o login em segundo plano
    private class LoginTask extends AsyncTask<String, Void, Usuario> {

        @Override
        protected Usuario doInBackground(String... params) {
            String email = params[0];  // Pega o email
            String senha = params[1];  // Pega a senha

            // Acessa o banco de dados para verificar se o usuário existe
            return db.usuarioDao().login(email, senha);  // Consulta no banco de dados
        }

        @Override
        protected void onPostExecute(Usuario usuario) {
            super.onPostExecute(usuario);
            if (usuario != null) {
                // Login bem-sucedido, redireciona para a MainActivity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Fecha a LoginActivity
            } else {
                Toast.makeText(LoginActivity.this, "Email ou senha incorretos!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
