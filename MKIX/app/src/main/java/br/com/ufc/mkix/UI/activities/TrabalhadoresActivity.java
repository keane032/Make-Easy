package br.com.ufc.mkix.UI.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.UI.adapters.RVTrabalhadorAdapter;
import br.com.ufc.mkix.model.Trabalhador;
import br.com.ufc.mkix.model.enums.Categoria;
import br.com.ufc.mkix.persistence.PersistenceUnit;
import br.com.ufc.mkix.service.TrabalhadoresActivityService;

public class TrabalhadoresActivity extends AppCompatActivity {

    private TrabalhadoresActivityService service = new TrabalhadoresActivityService();
    private DatabaseReference mDatabase;
    private List<Trabalhador> trabs = new ArrayList<>();
    Context context = this;
    private String cat;
    int select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabalhadores);

        RecyclerView rv = findViewById(R.id.rv_trabalhadores);
        cat = getIntent().getStringExtra("categoria");

        mDatabase = PersistenceUnit.getInstance().getReference("trabalhadores");

        mDatabase.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                trabs.clear();
                int cont = 0;
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Trabalhador trabalhador = postSnapshot.getValue(Trabalhador.class);
                    for (Categoria categoria : trabalhador.getSkills()) {
                       if(cat.equals(categoria.toString())) {
                           trabs.add(trabalhador);
                           Log.d("wqqeqweqeqw", "" + trabs.get(cont).getNome());
                           cont++;
                       }
                    }
                }
                RVTrabalhadorAdapter RVAdapter = new RVTrabalhadorAdapter(trabs);
                LinearLayoutManager llm = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                rv.setLayoutManager(llm);
                rv.setAdapter(RVAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    public void onClickGetPosition(View view){
        Intent intent = new Intent(this, MapsActivity.class);
//        intent.putExtra("endereco",categoria);
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
        intent.putExtra("nome",service.getTrabalhadorByPosition(0).getNome());
        intent.putExtra("email",service.getTrabalhadorByPosition(0).getEmail());
        intent.putExtra("contato",service.getTrabalhadorByPosition(0).getContatos().get(0).getNumero());
        intent.putExtra("photoId",service.getTrabalhadorByPosition(0).getPhotoId());
        startActivity(intent);
    }
}
