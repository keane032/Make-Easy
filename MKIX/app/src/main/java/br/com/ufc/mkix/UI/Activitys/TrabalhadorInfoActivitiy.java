package br.com.ufc.mkix.UI.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.model.Trabalhador;

public class TrabalhadorInfoActivitiy extends AppCompatActivity {

    private Trabalhador trabson = new Trabalhador();
    private ImageView photo;
    private TextView email;
    private TextView nome;
    private TextView contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabalhador_info_activitiy);
        initViews();
        getTrabson();
        updateView();
    }

    private void getTrabson(){
        Intent i = getIntent();
        trabson.setNome(i.getStringExtra("nome"));
        trabson.setDescricao(i.getStringExtra("contato"));
        trabson.setEmail(i.getStringExtra("email"));
        trabson.setPhotoId((i.getIntExtra("photoId",R.drawable.ic_launcher_background)));
    }

    private void updateView(){
        email.setText(trabson.getEmail());
        nome.setText(trabson.getNome());
        contato.setText(trabson.getDescricao());
        photo.setImageResource(trabson.getPhotoId());
    }

    private void initViews(){
        this.photo = findViewById(R.id.user_info_photo);
        this.email = findViewById(R.id.user_info_email);
        this.nome = findViewById(R.id.user_info_nome);
        this.contato = findViewById(R.id.user_info_contato);
    }
}
