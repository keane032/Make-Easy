package br.com.ufc.mkix.UI.activities;

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
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.model.enums.Categoria;

public class Home extends AppCompatActivity  {

    List<String> categorias = new ArrayList<>();
    ListView ViewCategorias;
    AutoCompleteTextView autoCompleteTextView;

    DatabaseReference mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        mydatabase = FirebaseDatabase.getInstance().getReference("categorias");

//        mydatabase.child("0").setValue(Categoria.EMPREGADA);
//        mydatabase.child("1").setValue(Categoria.MORDOMO);
//        mydatabase.child("2").setValue(Categoria.PEDREIRO);
//        mydatabase.child("3").setValue(Categoria.PISCINEIRO);
//        mydatabase.child("4").setValue(Categoria.ENCANADOR);
//        mydatabase.child("5").setValue(Categoria.DIARISTA);
//        mydatabase.child("6").setValue(Categoria.COZINHA);
//        mydatabase.child("7").setValue(Categoria.CHURRASQUEIRO);
//        mydatabase.child("8").setValue(Categoria.ELETRICISTA);
//        mydatabase.child("9").setValue(Categoria.CARPINTEIRO);
//        mydatabase.child("10").setValue(Categoria.BABA);

        mydatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Categoria categoria = postSnapshot.getValue(Categoria.class);
                    //adding artist to the list
                    categorias.add(categoria.toString());
                }

                autoCompleteTextView = findViewById(R.id.CampoDeBusca);

                ViewCategorias = (ListView) findViewById(R.id.Categorias);

                autoCompleteTextView.setThreshold(1); //will start working from first character

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        getBaseContext(),
                        android.R.layout.simple_list_item_1,
                        categorias);

                ArrayAdapter<String> AutoarrayAdapter = new ArrayAdapter<String>(
                        getBaseContext(),
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

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getBaseContext(),"errro",Toast.LENGTH_SHORT).show();
            }
        });



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
