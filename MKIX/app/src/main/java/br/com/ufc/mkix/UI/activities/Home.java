package br.com.ufc.mkix.UI.activities;

import android.app.ProgressDialog;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.model.enums.Categoria;
import br.com.ufc.mkix.persistence.PersistenceUnit;

public class Home extends AppCompatActivity  {

    List<String> categorias = new ArrayList<>();
    ListView ViewCategorias;
    AutoCompleteTextView autoCompleteTextView;

    private Boolean ready = false;

    ProgressDialog progressDialog;

    DatabaseReference mydatabase;
    PersistenceUnit persistenceUnit = PersistenceUnit.getInstance();

    Runnable t1 = new Runnable() {
        public void run() {
            try{
               progressDialog.show();
            } catch (Exception e){}
        }
    };

    Runnable t2 = new Runnable() {
        public void run() {
            try{
                syncronizeDatabase();
                progressDialog.dismiss();
            } catch (Exception e){}
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        progressDialog = new ProgressDialog(Home.this);
        progressDialog.setMessage("loading...");

        initFirebase();

        this.t1.run();
        this.t2.run();

    }

    private void initFirebase(){
        if (mydatabase == null){
            mydatabase = persistenceUnit.getReference();
        }
    }

    private void syncronizeDatabase() {


        mydatabase.child("categorias").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                categorias.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Categoria categoria = postSnapshot.getValue(Categoria.class);
                    categorias.add(categoria.toString());
                }

                initViewCategorias();
                initAutoCompleteAdapter();
                ready = true;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getBaseContext(),"errro",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initAutoCompleteAdapter() {
        ArrayAdapter<String> AutoarrayAdapter =
                new ArrayAdapter<String>(
                    getBaseContext(),
                    android.R.layout.simple_list_item_1,
                    categorias
        );

        autoCompleteTextView = findViewById(R.id.CampoDeBusca);
        autoCompleteTextView.setThreshold(1); //will start working from first character
        autoCompleteTextView.setAdapter(AutoarrayAdapter);
    }

    private void initViewCategorias(){
        ViewCategorias = findViewById(R.id.Categorias);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getBaseContext(),
                android.R.layout.simple_list_item_1,
                categorias);

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
        intent.putExtra("categoria",categoria);
        startActivity(intent);
    }
}
