package br.com.ufc.mkix.UI.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.model.Contato;
import br.com.ufc.mkix.model.Trabalhador;
import br.com.ufc.mkix.model.enums.Categoria;

public class ClienteActivity extends Activity {

    EditText nome;
    EditText sobrenome;
    EditText email;
    EditText cpf;
    EditText senha;

    ArrayList<Trabalhador> clientes =  new ArrayList<Trabalhador>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_clientes);


        nome = (EditText) findViewById(R.id.editTextNome);
        sobrenome = (EditText) findViewById(R.id.editTextSNome);
        email = (EditText) findViewById(R.id.editTextEmail);
        cpf = (EditText) findViewById(R.id.editTextCpf);
        senha = (EditText) findViewById(R.id.editTextSenha);

    }


    public void cadastrarCliente(View view){
        String snome = nome.getText().toString();
        String ssobrenome = sobrenome.getText().toString();
        String semail = email.getText().toString();
        String scpf = cpf.getText().toString();
        String ssenha = senha.getText().toString();


        List<Contato> contatos = new ArrayList<>();
        contatos.add(new Contato("8889898989","Tim"));
        contatos.add(new Contato("8889898989","Oi"));

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(Categoria.CARPINTEIRO);
        categorias.add(Categoria.ELETRICISTA);
        categorias.add(Categoria.COZINHA);

        clientes.add(new Trabalhador(1L,snome,ssobrenome,semail,ssenha,new LatLng(-4.980706, -39.021918)
                ,scpf,contatos, categorias,"Olá, quero lhe ajudar", R.drawable.image));


        Toast.makeText(ClienteActivity.this, "usuario cadastrado", Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(this, Home.class);
        startActivity(intent);

    }

}
