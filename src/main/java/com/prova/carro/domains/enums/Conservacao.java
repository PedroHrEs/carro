package com.prova.carro.domains.enums;

public enum Conservacao {

    NOVO(0, "NOVO"), USADO(1, "USADO"), GASTO(2, "GASTO");

    private Integer id;
    private String situacaocarro;

    Conservacao(Integer id, String situacaocarro) {
        this.id = id;
        this.situacaocarro = situacaocarro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSituacaocarro() {
        return situacaocarro;
    }

    public void setSituacaocarro(String situacaocarro) {
        this.situacaocarro = situacaocarro;
    }
    public static Conservacao toEnum(Integer id) {
        if (id == null) return null;
        for (Conservacao x : Conservacao.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Status inválido");
    }
}
