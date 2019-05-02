package br.com.ufc.mkix.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class Cliente extends Usuario {
    private Issue issue;

    public Cliente(Long id, String nome, String email, LatLng position, List<Contato> contatos, Issue issue) {
        super(id, nome, email, position, contatos);
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
