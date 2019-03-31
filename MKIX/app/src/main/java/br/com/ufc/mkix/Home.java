package br.com.ufc.mkix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity  {

    List<String> categorias = new ArrayList<>();
    ListView ViewCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        categorias.add("Obras");
        categorias.add("Entreterimento");
        categorias.add("Eletricismo");
        categorias.add("Cozinha");
        categorias.add("Moveis");

        ViewCategorias = (ListView) findViewById(R.id.Categorias);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                categorias);

        ViewCategorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {
                String cat = (String) parent.getItemAtPosition(posicao);
                escolherCategoria(cat);

            }
        });

        ViewCategorias.setAdapter(arrayAdapter);

    }


    public void escolherCategoria(String categoria){
        Toast.makeText(Home.this, categoria, Toast.LENGTH_SHORT).show();
//        Criar intent para lista de trabalhadores
    }

    public void buscarPorNome(View view){
        EditText editText = (EditText) findViewById(R.id.CampoDeBusca);
        String nome = editText.getText().toString();
        Toast.makeText(Home.this, nome, Toast.LENGTH_SHORT).show();
        //        Criar intent para lista de trabalhadores
    }

}
