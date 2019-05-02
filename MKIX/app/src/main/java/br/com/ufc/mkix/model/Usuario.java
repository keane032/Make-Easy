package br.com.ufc.mkix.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private LatLng position;
    private String cpf;
    private List<Contato> contatos;

    public Usuario(Long id, String nome, String sobrenome,String email, String senha,LatLng position, String cpf, List<Contato> contatos) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.position = position;
        this.contatos = contatos;
        this.cpf = cpf;
    }

    public Usuario() {
        this.id = 0L;
        this.nome = "";
        this.sobrenome = "";
        this.email = "";
        this.senha = "";
        this.position = new LatLng(0,0);
        this.cpf = "";
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
