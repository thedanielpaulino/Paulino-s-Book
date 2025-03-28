package com.example.testetcc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvBemVindo;
    private Button btnSair;
    private String usuarioNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando as views
        tvBemVindo = findViewById(R.id.tvBemVindo);
        btnSair = findViewById(R.id.btnSair);

        // Receber o nome do usuário, enviado do LoginActivity após o login
        usuarioNome = getIntent().getStringExtra("usuario_nome");
        if (usuarioNome != null) {
            tvBemVindo.setText("Bem-vindo, " + usuarioNome + "!");
        }

        // Lógica do botão Sair
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quando o usuário clicar em "Sair", o app volta para a LoginActivity
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Fecha a MainActivity
            }
        });

        // Outros elementos e funcionalidades da MainActivity podem ser adicionados aqui, como listas, botões, etc.
    }
}
