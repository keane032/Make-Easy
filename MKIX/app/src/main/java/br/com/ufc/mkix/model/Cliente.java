package br.com.ufc.mkix.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

public class Cliente {


    private String id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String cpf;

    public Cliente(String id, String nome, String sobrenome,
                   String email, String senha,String cpf) {
        this.id = id;

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;

    }

    public Cliente() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //    public Issue getIssue() {
//        return issue;
//    }

//    public void setIssue(Issue issue) {
//        this.issue = issue;
//    }
}
