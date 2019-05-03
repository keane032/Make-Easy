package br.com.ufc.mkix.UI.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.model.enums.Categoria;

public class Home extends AppCompatActivity  {

    List<String> categorias = new ArrayList<>();
    ListView ViewCategorias;
    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        categorias.add(Categoria.EMPREGADA.toString());
        categorias.add(Categoria.BABA.toString());
        categorias.add(Categoria.CARPINTEIRO.toString());
        categorias.add(Categoria.CHURRASQUEIRO.toString());
        categorias.add(Categoria.COPEIRA.toString());
        categorias.add(Categoria.COZINHA.toString());
        categorias.add(Categoria.DIARISTA.toString());
        categorias.add(Categoria.ELETRICISTA.toString());
        categorias.add(Categoria.ENCANADOR.toString());
        categorias.add(Categoria.PISCINEIRO.toString());
        categorias.add(Categoria.PEDREIRO.toString());
        categorias.add(Categoria.MORDOMO.toString());

        autoCompleteTextView = findViewById(R.id.CampoDeBusca);

        ViewCategorias = (ListView) findViewById(R.id.Categorias);

        autoCompleteTextView.setThreshold(1); //will start working from first character

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                categorias);

        ArrayAdapter<String> AutoarrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                categorias);

        autoCompleteTextView.setAdapter(AutoarrayAdapter);


        ViewCategorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {
                String cat = (String) parent.getItemAtPosition(posicao);
                listarTrabalhadoresPorCategoria(cat);

            }
        });

        ViewCategorias.setAdapter(arrayAdapter);

    }


    public void buscarPorNome(View view){
        EditText editText = (EditText) findViewById(R.id.CampoDeBusca);
        String nome = editText.getText().toString();
        Toast.makeText(Home.this, nome, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, TrabalhadoresActivity.class);
        startActivity(intent);
    }

    public void listarTrabalhadoresPorCategoria(String categoria){
        Intent intent = new Intent(this, TrabalhadoresActivity.class);
        startActivity(intent);
    }
}
