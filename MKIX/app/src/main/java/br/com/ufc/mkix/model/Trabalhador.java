package br.com.ufc.mkix.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.mkix.model.enums.Categoria;

public class Trabalhador extends Usuario {
    private List<Categoria> skills;
    private String descricao;

    public Trabalhador(Long id,
                       String nome,
                       String email,
                       LatLng position,
                       List<Contato> contatos,
                       List<Categoria> skills,
                       String descricao) {
        super(id, nome, email, position, contatos);
        this.skills = skills;
        this.descricao = descricao;
    }

    public Trabalhador() {
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
