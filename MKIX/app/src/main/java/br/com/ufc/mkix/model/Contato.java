package br.com.ufc.mkix.model;

public class Contato {

    private String numero;
    private String operadora;

    public Contato(String numero, String operadora) {
        this.numero = numero;
        this.operadora = operadora;
    }

    public Contato() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }
}
