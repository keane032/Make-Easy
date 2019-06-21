package br.com.ufc.mkix.UI.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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

    GoogleSignInClient mGoogleSignInClient;

    List<String> categorias = new ArrayList<>();
    ListView ViewCategorias;
    AutoCompleteTextView autoCompleteTextView;

    private Boolean ready = false;

    ProgressDialog progressDialog;

    DatabaseReference mydatabase;
    PersistenceUnit persistenceUnit = PersistenceUnit.getInstance();

    Runnable dialogThread = new Runnable() {
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
        progressDialog.show();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        initFirebase();

        this.dialogThread.run();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.loggout_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.logout){
            logout();
        }

        return true;
    }

    private void logout() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Home.this,"Successfully signed out",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Home.this, MainActivity.class));
                        finish();
                    }
                });
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
