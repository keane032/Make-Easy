package br.com.ufc.mkix.model;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.mkix.model.enums.Categoria;

public class Issue {
    private Long id;
    private String titulo;
    private String descricao;
    private List<Categoria> categorias;

    public Issue(Long id, String titulo, String descricao, List<Categoria> categorias) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categorias = categorias;
    }

    public Issue() {
        this.id = 0L;
        this.titulo = "";
        this.descricao = "";
        this.categorias = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
