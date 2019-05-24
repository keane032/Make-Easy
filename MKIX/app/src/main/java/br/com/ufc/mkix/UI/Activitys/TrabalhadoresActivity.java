package br.com.ufc.mkix.UI.Activitys;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.TrabalhadoresActivityService;
import br.com.ufc.mkix.UI.Activitys.adapters.RVTrabalhadorAdapter;

public class TrabalhadoresActivity extends AppCompatActivity {

    private TrabalhadoresActivityService service = new TrabalhadoresActivityService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabalhadores);

        RecyclerView rv = findViewById(R.id.rv_trabalhadores);
        RVTrabalhadorAdapter RVAdapter = new RVTrabalhadorAdapter(service.getTrabalhadoresByCategoria(getIntent().getStringExtra("categoria")));
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
        intent.putExtra("nome",service.getTrabalhadorByPosition(0).getNome());
        intent.putExtra("email",service.getTrabalhadorByPosition(0).getEmail());
        intent.putExtra("contato",service.getTrabalhadorByPosition(0).getContatos().get(0).getNumero());
        intent.putExtra("photoId",service.getTrabalhadorByPosition(0).getPhotoId());
        startActivity(intent);
    }

}
