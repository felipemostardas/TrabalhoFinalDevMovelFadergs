package com.example.trabalhofinaldevmovelfadergs.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.example.trabalhofinaldevmovelfadergs.R;
import com.example.trabalhofinaldevmovelfadergs.helper.ConfiguracaoFirebase;


public class AnunciosActivity extends AppCompatActivity {

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios);

        //Configurações iniciais
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();

        //autenticacao.signOut();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if( autenticacao.getCurrentUser() == null ){//usuario deslogado
            menu.setGroupVisible(R.id.group_deslogado,true);
        }else {//Usuario logado
            menu.setGroupVisible(R.id.group_logado, true);
        }

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch ( item.getItemId() ){
            case R.id.menu_cadastrar :
                startActivity( new Intent(getApplicationContext(), CadastroActivity.class));
                break;
            case R.id.menu_sair :
                autenticacao.signOut();
                invalidateOptionsMenu();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
