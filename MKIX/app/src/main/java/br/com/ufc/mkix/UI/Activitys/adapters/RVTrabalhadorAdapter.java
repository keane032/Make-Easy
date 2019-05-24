package br.com.ufc.mkix.UI.Activitys.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.UI.Activitys.TrabalhadorInfoActivitiy;
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
        TrabalhadorViewHolder tvh = new TrabalhadorViewHolder(v,this.trabalhadores);
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
        RecyclerView recyclerView;

        public TrabalhadorViewHolder(@NonNull final View itemView, final List<Trabalhador> trabalhadores) {
            super(itemView);
            this.cv = itemView.findViewById(R.id.cv_id);
            this.tvNome = itemView.findViewById(R.id.user_nome);
            this.tvDescricao = itemView.findViewById(R.id.user_descricao);

            this.ivPhoto = itemView.findViewById(R.id.user_photo);
            this.recyclerView = itemView.findViewById(R.id.rv_trabalhadores);

            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();

                    Intent intent = new Intent(context, TrabalhadorInfoActivitiy.class);

                    Toast toast = Toast.makeText(context, "",Toast.LENGTH_SHORT);
                    toast.show();

                    intent.putExtra("nome",trabalhadores.get(0).getNome());
                    intent.putExtra("email",trabalhadores.get(0).getEmail());
                    intent.putExtra("contato",trabalhadores.get(0).getContatos().get(0).getNumero());
                    intent.putExtra("photoId",trabalhadores.get(0).getPhotoId());

                    context.startActivity(intent);
                }
            });

        }


    }

    }
