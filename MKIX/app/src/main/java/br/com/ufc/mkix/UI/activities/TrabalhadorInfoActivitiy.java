package br.com.ufc.mkix.UI.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.pchmn.materialchips.ChipsInput;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.model.Trabalhador;
import br.com.ufc.mkix.model.enums.Categoria;

public class TrabalhadorInfoActivitiy extends AppCompatActivity {

    private Trabalhador trabson = new Trabalhador();
    private ImageView photo;
    private TextView email;
    private TextView nome;
    private TextView contato;
    private ChipsInput chipsInput;


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

        String[] skills = i.getStringExtra("skills").split(",");
        List<Categoria> categorias = new ArrayList<>();
        for (String cat: skills){
            categorias.add(Categoria.valueOf(cat));
        }
        trabson.setSkills(categorias);
    }

    private void updateView(){
        email.setText(trabson.getEmail());
        nome.setText(trabson.getNome());
        contato.setText(trabson.getDescricao());
        photo.setImageResource(trabson.getPhotoId());
        for (Categoria categoria: trabson.getSkills()){
            chipsInput.addChip(categoria.name(),"Categoria");
        }
    }

    private void initViews(){
        photo = findViewById(R.id.user_info_photo);
        email = findViewById(R.id.user_info_email);
        nome = findViewById(R.id.user_info_nome);
        contato = findViewById(R.id.user_info_contato);
        chipsInput = findViewById(R.id.chips_input);
    }
}
