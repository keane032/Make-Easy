package br.com.ufc.mkix.UI.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.UI.activities.TrabalhadorInfoActivitiy;
import br.com.ufc.mkix.model.Trabalhador;
import br.com.ufc.mkix.model.enums.Categoria;

public class RVTrabalhadorAdapter extends RecyclerView.Adapter<RVTrabalhadorAdapter.TrabalhadorViewHolder> {

    private List<Trabalhador> trabalhadores;

    public RVTrabalhadorAdapter(List<Trabalhador> trabalhadores) {
        this.trabalhadores = trabalhadores;
    }

    @NonNull
    @Override
    public TrabalhadorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d("ids",""+ i);
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.worker_card, viewGroup, false);
        TrabalhadorViewHolder tvh = new TrabalhadorViewHolder(v,this.trabalhadores);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TrabalhadorViewHolder trabalhadorViewHolder, int i) {
        Log.d("wqqwqe",""+ i);
        trabalhadorViewHolder.tvNome.setText(trabalhadores.get(i).getNome());
        trabalhadorViewHolder.tvDescricao.setText(trabalhadores.get(i).getDescricao());
        Picasso.get()
                .load(trabalhadores.get(i).getPhotoId())
                .error(R.drawable.ic_launcher_background)
                .into(trabalhadorViewHolder.ivPhoto);
        trabalhadorViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Log.d("wqqwqe","");
                Intent intent = new Intent(context, TrabalhadorInfoActivitiy.class);

                Toast toast = Toast.makeText(context, "",Toast.LENGTH_SHORT);
                toast.show();

                StringBuilder skills = new StringBuilder();

                intent.putExtra("nome",trabalhadores.get(i).getNome());
                intent.putExtra("email",trabalhadores.get(i).getEmail());
                intent.putExtra("contato",trabalhadores.get(i).getContatos().get(i).getNumero());
                intent.putExtra("photoId",trabalhadores.get(i).getPhotoId());
                intent.putExtra("position",trabalhadores.get(i).getPosition().toString());


                for (Categoria skill: trabalhadores.get(i).getSkills()) {
                    skills.append(skill.name());
                    skills.append(",");
                }

                intent.putExtra("skills",skills.toString());

                context.startActivity(intent);
            }
        });

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
                    Log.d("wqqwqe","");
                    Intent intent = new Intent(context, TrabalhadorInfoActivitiy.class);

                    Toast toast = Toast.makeText(context, "",Toast.LENGTH_SHORT);
                    toast.show();

                    StringBuilder skills = new StringBuilder();

                    intent.putExtra("nome",trabalhadores.get(0).getNome());
                    intent.putExtra("email",trabalhadores.get(0).getEmail());
                    intent.putExtra("contato",trabalhadores.get(0).getContatos().get(0).getNumero());
                    intent.putExtra("photoId",trabalhadores.get(0).getPhotoId());
                    intent.putExtra("position",trabalhadores.get(0).getPosition().toString());


                    for (Categoria skill: trabalhadores.get(0).getSkills()) {
                        skills.append(skill.name());
                        skills.append(",");
                    }

                    intent.putExtra("skills",skills.toString());

                    context.startActivity(intent);
                }
            });

        }


    }

    }
