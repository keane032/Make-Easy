package br.com.ufc.mkix.UI.Activitys;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.UI.Activitys.adapters.RVTrabalhadorAdapter;
import br.com.ufc.mkix.model.Contato;
import br.com.ufc.mkix.model.Trabalhador;
import br.com.ufc.mkix.model.enums.Categoria;

public class TrabalhadoresActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabalhadores);

        RecyclerView rv = findViewById(R.id.rv_trabalhadores);
        RVTrabalhadorAdapter RVAdapter = new RVTrabalhadorAdapter(initValues());
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
        rv.setAdapter(RVAdapter);
    }

    public void onClickGetPosition(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void onClickSendEmail(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "email@emailaddress.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Make Easy");
        intent.putExtra(Intent.EXTRA_TEXT, "Preciso da Sua Ajuda!");

        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    public void onClickCall(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0123456789"));
        startActivity(intent);
    }


    private List<Trabalhador> initValues(){
        List<Trabalhador> teste = new ArrayList<>();

        List<Contato> contatos = new ArrayList<>();
        contatos.add(new Contato("8889898989","Tim"));
        contatos.add(new Contato("8889898989","Oi"));

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(Categoria.CARPINTEIRO);
        categorias.add(Categoria.ELETRICISTA);
        categorias.add(Categoria.COZINHA);

        teste.add(new Trabalhador(1L,"Paulo","Oliveira","email@email.com","123qwe",new LatLng(-4.980706, -39.021918),"",contatos, categorias,"Olá, quero lhe ajudar", R.drawable.image));
        teste.add(new Trabalhador(1L,"Lisa","Hofman","email@email.com","123qwe",new LatLng(-4.980705, -39.022918), "",contatos, categorias,"Olá, quero lhe ajudar", R.drawable.image__1_));
        teste.add(new Trabalhador(1L,"Laura","Ferreira","email@email.com","123qwe",new LatLng(-4.980704, -39.023918),"",contatos, categorias,"Olá, quero lhe ajudar", R.drawable.image__2_));
        teste.add(new Trabalhador(1L,"Isabella","Coutinho","email@email.com","123qwe",new LatLng(-4.980703, -39.024918),"",contatos, categorias,"Olá, quero lhe ajudar", R.drawable.image__3_));
        teste.add(new Trabalhador(1L,"Richard","Farias","email@email.com","123qwe",new LatLng(-4.980702, -39.025918),"",contatos, categorias,"Olá, quero lhe ajudar", R.drawable.image__4_));
        teste.add(new Trabalhador(1L,"Arnaldo","dos Santos","email@email.com","123qwe",new LatLng(-4.980701, -39.026918),"",contatos, categorias,"Olá, quero lhe ajudar", R.drawable.image__5_));

        return teste;
    }
}
