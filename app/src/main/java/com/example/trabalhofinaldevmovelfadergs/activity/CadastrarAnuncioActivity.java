package com.example.trabalhofinaldevmovelfadergs.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.blackcat.currencyedittext.CurrencyEditText;
import com.example.trabalhofinaldevmovelfadergs.R;

import java.util.Locale;

public class CadastrarAnuncioActivity extends AppCompatActivity {

    private EditText campoTitulo, campoDescricao;
    private CurrencyEditText campoValor;
    private EditText campoTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_anuncio);

        inicializarComponentes();
    }

    public void salvarAnuncio(View view){

        String valor = campoValor.getText().toString();
        Log.d("salvar", "salvarAnuncio: " + valor );

    }

    private void inicializarComponentes(){

        campoTitulo = findViewById(R.id.editTitulo);
        campoDescricao = findViewById(R.id.editDescricao);
        campoValor = findViewById(R.id.editValor);
        campoTelefone = findViewById(R.id.editTelefone);

        //configurar portugues brasil para aparecei reais na mascara da moeda
        Locale locale = new Locale("pt", "BR");
        campoValor.setLocale(locale);

    }

}
