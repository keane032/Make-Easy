package br.com.ufc.mkix.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    private Long id;
    private String nome;
    private String email;
    private LatLng position;
    private List<Contato> contatos;

    public Usuario(Long id, String nome, String email, LatLng position, List<Contato> contatos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.position = position;
        this.contatos = contatos;
    }

    public Usuario() {
        this.id = 0L;
        this.nome = "";
        this.email = "";
        this.position = new LatLng(0,0);
        this.contatos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LatLng getPosition() {
        return position;
    }

    public void setPosition(LatLng position) {
        this.position = position;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
