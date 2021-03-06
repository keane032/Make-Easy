package br.com.ufc.mkix.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.model.enums.Categoria;

public class Trabalhador extends Usuario {
    private List<Categoria> skills;
    private String descricao;
    private int photoId = R.drawable.default_profile;


    public Trabalhador(Long id,
                       String nome,
                       String sobrenome,
                       String email,
                       String senha,
                       String position,
                       String cpf,
                       List<Contato> contatos,
                       List<Categoria> skills,
                       String descricao,
                       int photoId) {
        super(id, nome, sobrenome, email, senha, position, cpf, contatos);
        this.skills = skills;
        this.descricao = descricao;
        this.photoId =photoId;
    }

    public Trabalhador(){ }

    public int getPhotoId() {
        return this.photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public Trabalhador(long id, String paulo, String oliveira, String email, String senha, LatLong latLong, String cpf, List<Contato> contatos, List<Categoria> categorias, String descricao, int image) {
        super();
        this.skills = new ArrayList<>();
        this.descricao = "";
    }

    public List<Categoria> getSkills() {
        return skills;
    }

    public void setSkills(List<Categoria> skills) {
        this.skills = skills;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
