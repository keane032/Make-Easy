package br.com.ufc.mkix.UI.Activitys.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.model.Contato;
import br.com.ufc.mkix.model.Trabalhador;
import br.com.ufc.mkix.model.enums.Categoria;

public class RVTrabalhadorAdapter extends RecyclerView.Adapter<RVTrabalhadorAdapter.TrabalhadorViewHolder> {

    private List<Trabalhador> trabalhadores;

    public RVTrabalhadorAdapter(List<Trabalhador> trabalhadores) {
        this.trabalhadores = trabalhadores;
    }

    public RVTrabalhadorAdapter(){
        this.trabalhadores = initValues();
    }

    @NonNull
    @Override
    public TrabalhadorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.worker_card, viewGroup, false);
        TrabalhadorViewHolder tvh = new TrabalhadorViewHolder(v);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TrabalhadorViewHolder trabalhadorViewHolder, int i) {
        this.trabalhadores = initValues();
        trabalhadorViewHolder.tvNome.setText(trabalhadores.get(i).getNome());
        trabalhadorViewHolder.tvDescricao.setText(trabalhadores.get(i).getDescricao());
        trabalhadorViewHolder.ivPhoto.setImageResource(trabalhadores.get(i).getPhotoId());
    }

    @Override
    public int getItemCount() {
        return this.trabalhadores.size();
    }

    public static class TrabalhadorViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView tvNome;
        TextView tvDescricao;
        ImageView ivPhoto;


        public TrabalhadorViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cv = (CardView)itemView.findViewById(R.id.cv_id);
            this.tvNome = (TextView)itemView.findViewById(R.id.user_nome);
            this.tvDescricao = (TextView)itemView.findViewById(R.id.user_descricao);
            this.ivPhoto = (ImageView) itemView.findViewById(R.id.user_photo);
        }
    }

    private List<Trabalhador> initValues(){
        List<Trabalhador> teste = new ArrayList<>();

        List<Contato> contatos = new ArrayList<>();
        contatos.add(new Contato("8889898989","Tim"));
        contatos.add(new Contato("8889898989","Oi"));

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(Categoria.CARPINTEIRO);
        categorias.add(Categoria.ELETRICISTA);
        categorias.add(Categoria.COZINHA);

        teste.add(new Trabalhador(1L,"Paulo","Oliveira","email@email.com","123qwe",new LatLng(-4.980706, -39.021918),contatos, categorias,"Olá, quero lhe ajudar", R.drawable.image));
        teste.add(new Trabalhador(1L,"Lisa","Hofman","email@email.com","123qwe",new LatLng(-4.980705, -39.022918),contatos, categorias,"Olá, quero lhe ajudar", R.drawable.image__1_));
        teste.add(new Trabalhador(1L,"Laura","Ferreira","email@email.com","123qwe",new LatLng(-4.980704, -39.023918),contatos, categorias,"Olá, quero lhe ajudar", R.drawable.image__2_));
        teste.add(new Trabalhador(1L,"Isabella","Coutinho","email@email.com","123qwe",new LatLng(-4.980703, -39.024918),contatos, categorias,"Olá, quero lhe ajudar", R.drawable.image__3_));
        teste.add(new Trabalhador(1L,"Richard","Farias","email@email.com","123qwe",new LatLng(-4.980702, -39.025918),contatos, categorias,"Olá, quero lhe ajudar", R.drawable.image__4_));
        teste.add(new Trabalhador(1L,"Arnaldo","dos Santos","email@email.com","123qwe",new LatLng(-4.980701, -39.026918),contatos, categorias,"Olá, quero lhe ajudar", R.drawable.image__5_));

        return teste;
    }
}
