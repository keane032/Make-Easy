package br.com.ufc.mkix.UI.Activitys.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.model.Trabalhador;

public class RVTrabalhadorAdapter extends RecyclerView.Adapter<RVTrabalhadorAdapter.TrabalhadorViewHolder> {

    private List<Trabalhador> trabalhadores;

    public RVTrabalhadorAdapter(List<Trabalhador> trabalhadores) {
        this.trabalhadores = trabalhadores;
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
        trabalhadorViewHolder.tvNome.setText(trabalhadores.get(i).getNome());
        trabalhadorViewHolder.tvDescricao.setText(trabalhadores.get(i).getDescricao());
        Picasso.get()
                .load(trabalhadores.get(i).getPhotoId())
                .error(R.drawable.ic_launcher_background)
                .into(trabalhadorViewHolder.ivPhoto);
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
}
