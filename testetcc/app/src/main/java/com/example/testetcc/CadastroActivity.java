package com.example.testetcc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testetcc.database.AppDatabase;
import com.example.testetcc.model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    // Campos de entrada para nome, email e senha do usuário
    private EditText etNome, etEmail, etSenha;
    private Button btnCadastrar; // Botão para concluir cadastro
    private AppDatabase db; // Instância do banco de dados

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // Inicializa os componentes da interface
        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        db = AppDatabase.getInstance(this); // Obtém a instância do banco de dados

        // Configuração do botão de cadastro
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtém os valores digitados pelo usuário
                String nome = etNome.getText().toString();
                String email = etEmail.getText().toString();
                String senha = etSenha.getText().toString();

                // Verifica se todos os campos foram preenchidos
                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Cria um novo objeto de usuário e insere no banco de dados
                Usuario novoUsuario = new Usuario(nome, email, senha);
                db.usuarioDao().inserir(novoUsuario);

                // Exibe uma mensagem de sucesso e finaliza a atividade
                Toast.makeText(CadastroActivity.this, "Usuário cadastrado!", Toast.LENGTH_SHORT).show();
                finish(); // Fecha a tela de cadastro e retorna para a tela de login
            }
        });
    }
}
