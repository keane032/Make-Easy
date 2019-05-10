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


    private List<Trabalhador> trabalhadores = initValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabalhadores);

        RecyclerView rv = findViewById(R.id.rv_trabalhadores);
        RVTrabalhadorAdapter RVAdapter = new RVTrabalhadorAdapter(getTrabalhadoresByCategoria(getIntent().getStringExtra("categoria")));
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
        rv.setAdapter(RVAdapter);
    }

    public void onClickGetPosition(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void onClickSendEmail(View view){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","abc@gmail.com", null));

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Make easy");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Preciso de sua ajuda");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    public void onClickCall(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0123456789"));
        startActivity(intent);
    }

    public void onClickgGetInfo(View view){
        Intent intent = new Intent(this, TrabalhadorInfoActivitiy.class);
        intent.putExtra("nome",trabalhadores.get(0).getNome());
        intent.putExtra("email",trabalhadores.get(0).getEmail());
        intent.putExtra("contato",trabalhadores.get(0).getContatos().get(0).getNumero());
        intent.putExtra("photoId",trabalhadores.get(0).getPhotoId());
        startActivity(intent);
    }

    //Mocks
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

        List<Categoria> categorias2 = new ArrayList<>();
        categorias2.add(Categoria.BABA);
        categorias2.add(Categoria.COPEIRA);
        categorias2.add(Categoria.COZINHA);
        categorias2.add(Categoria.EMPREGADA);

        teste.add(new Trabalhador(1L,"Lisa","Hofman","email@email.com","123qwe",new LatLng(-4.980705, -39.022918), "",contatos, categorias2,"Olá, quero lhe ajudar", R.drawable.image__1_));

        List<Categoria> categorias3 = new ArrayList<>();
        categorias3.add(Categoria.DIARISTA);
        categorias3.add(Categoria.LAVADEIRA);
        categorias3.add(Categoria.GARCOM);


        teste.add(new Trabalhador(1L,"Laura","Ferreira","email@email.com","123qwe",new LatLng(-4.980704, -39.023918),"",contatos, categorias3,"Olá, quero lhe ajudar", R.drawable.image__2_));

        List<Categoria> categorias4 = new ArrayList<>();
        categorias4.add(Categoria.GARCOM);
        categorias4.add(Categoria.EMPREGADA);
        categorias4.add(Categoria.OUTRO);


        teste.add(new Trabalhador(1L,"Isabella","Coutinho","email@email.com","123qwe",new LatLng(-4.980703, -39.024918),"",contatos, categorias4,"Olá, quero lhe ajudar", R.drawable.image__3_));

        List<Categoria> categorias5 = new ArrayList<>();
        categorias5.add(Categoria.CARPINTEIRO);
        categorias5.add(Categoria.MORDOMO);
        categorias5.add(Categoria.GARCOM);
        categorias5.add(Categoria.PISCINEIRO);


        teste.add(new Trabalhador(1L,"Richard","Farias","email@email.com","123qwe",new LatLng(-4.980702, -39.025918),"",contatos, categorias5,"Olá, quero lhe ajudar", R.drawable.image__4_));

        List<Categoria> categorias6 = new ArrayList<>();
        categorias6.add(Categoria.MORDOMO);
        categorias6.add(Categoria.ELETRICISTA);
        categorias6.add(Categoria.CHURRASQUEIRO);
        categorias6.add(Categoria.LAVADEIRA);


        teste.add(new Trabalhador(1L,"Arnaldo","dos Santos","email@email.com","123qwe",new LatLng(-4.980701, -39.026918),"",contatos, categorias6,"Olá, quero lhe ajudar", R.drawable.image__5_));


        return teste;
    }

    //Mock
    private List<Trabalhador> getTrabalhadoresByCategoria(String categoria){
        List<Trabalhador> trabalhadoresPorCategoria = new ArrayList<>();

        for (Trabalhador i:trabalhadores){
            for (Categoria cat:i.getSkills()){
                if (cat.toString().equals(categoria)){
                    trabalhadoresPorCategoria.add(i);
                }
            }
        }

        return trabalhadoresPorCategoria;
    }
}
