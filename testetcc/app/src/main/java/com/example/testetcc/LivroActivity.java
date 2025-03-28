package com.example.testetcc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.testetcc.database.AppDatabase;
import com.example.testetcc.model.Livro;
import java.util.List;

public class LivroActivity extends AppCompatActivity {

    // Declaração dos campos de entrada para informações do livro
    private EditText etTitulo, etEscritor, etIdioma, etSinopse;
    private Button btnAdicionarLivro; // Botão para adicionar um novo livro
    private ListView lvLivros; // ListView para exibir os livros cadastrados
    private AppDatabase db; // Instância do banco de dados

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getInstance(this); // Obtém a instância do banco de dados

        // Configuração do botão para adicionar um novo livro
        btnAdicionarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtém os valores digitados pelo usuário
                String titulo = etTitulo.getText().toString();
                String escritor = etEscritor.getText().toString();
                String idioma = etIdioma.getText().toString();
                String sinopse = etSinopse.getText().toString();

                // Verifica se todos os campos estão preenchidos
                if (titulo.isEmpty() || escritor.isEmpty() || idioma.isEmpty() || sinopse.isEmpty()) {
                    Toast.makeText(LivroActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Cria um novo objeto Livro e insere no banco de dados
                Livro novoLivro = new Livro(escritor, sinopse, titulo, idioma);
                db.livroDao().inserir(novoLivro);

                Toast.makeText(LivroActivity.this, "Livro adicionado!", Toast.LENGTH_SHORT).show();
                carregarLivros(); // Atualiza a lista de livros
            }
        });

        carregarLivros(); // Carrega os livros cadastrados ao iniciar a tela
    }

    // Método para carregar todos os livros cadastrados no banco de dados
    private void carregarLivros() {
        List<Livro> livros = db.livroDao().getTodosLivros();
        // Aqui vamos adicionar um adapter para exibir os livros na ListView
    }
}
