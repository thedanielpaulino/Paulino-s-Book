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

    private EditText etTitulo, etEscritor, etIdioma, etSinopse;
    private Button btnAdicionarLivro;
    private ListView lvLivros;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db = AppDatabase.getInstance(this);

        btnAdicionarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = etTitulo.getText().toString();
                String escritor = etEscritor.getText().toString();
                String idioma = etIdioma.getText().toString();
                String sinopse = etSinopse.getText().toString();

                if (titulo.isEmpty() || escritor.isEmpty() || idioma.isEmpty() || sinopse.isEmpty()) {
                    Toast.makeText(LivroActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Livro novoLivro = new Livro(escritor, sinopse, titulo, idioma);
                db.livroDao().inserir(novoLivro);

                Toast.makeText(LivroActivity.this, "Livro adicionado!", Toast.LENGTH_SHORT).show();
                carregarLivros();
            }
        });

        carregarLivros();
    }

    private void carregarLivros() {
        List<Livro> livros = db.livroDao().getTodosLivros();
        // Aqui você pode adicionar um adapter para exibir os livros na ListView
    }
}
