package br.com.ufc.mkix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

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

        ViewCategorias.setAdapter(arrayAdapter);

    }


    public void escolherCategoria(View view){

    }

}
