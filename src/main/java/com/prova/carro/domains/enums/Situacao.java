package com.prova.carro.domains.enums;

public enum Situacao {

    ANDAMENTO(0, "ANDAMENTO"), AGDEVOLUCAO(1, "AGDEVOLUCAO"), DEVOLVIDO (2, "DEVOLVIDO");

    private Integer id;
    private String situacaoaluguel;

    Situacao(Integer id, String situacaoaluguel) {
        this.id = id;
        this.situacaoaluguel = situacaoaluguel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSituacaoaluguel() {
        return situacaoaluguel;
    }

    public void setSituacaoaluguel(String situacaoaluguel) {
        this.situacaoaluguel = situacaoaluguel;
    }

    public static Situacao toEnum(Integer id) {
        if (id == null) return null;
        for (Situacao x : Situacao.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Status inválido");
    }
}
