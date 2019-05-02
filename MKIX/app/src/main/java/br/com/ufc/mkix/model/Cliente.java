package br.com.ufc.mkix.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class Cliente extends Usuario {
    private Issue issue;

    public Cliente(Long id, String nome, String sobrenome, String email, String senha, LatLng position,String cpf, List<Contato> contatos, Issue issue) {
        super(id, nome, sobrenome, email, senha, position,cpf, contatos);
        this.issue = issue;
    }

    public Cliente() {
        super();
        this.issue = new Issue();
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }
}
