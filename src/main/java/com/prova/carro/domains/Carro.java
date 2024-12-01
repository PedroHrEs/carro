package com.prova.carro.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.prova.carro.domains.dtos.CarroDTO;
import com.prova.carro.domains.enums.Conservacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carro")
    private Integer idCarro;

    @NotBlank @NotNull
    private String marca;

    @NotBlank @NotNull
    private String modelo;

    @NotBlank @NotNull
    @Column(unique = true)
    private String placa;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "conservacao")
    private Conservacao conservacao;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idlocadora")
    private Locadora locadora;

    public Carro() {
    this.conservacao = Conservacao.NOVO;
    }

    public Carro(Integer idCarro, String marca, String modelo, String placa, Conservacao conservacao, Locadora locadora) {
        this.idCarro = idCarro;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.conservacao = conservacao;
        this.locadora = locadora;
    }

    public Carro(CarroDTO dto){
        this.idCarro = idCarro;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.conservacao = Conservacao.toEnum(dto.getConservacao());

        this.locadora = new Locadora();
        this.locadora.setIdLocadora(dto.getId());
    }

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public @NotBlank @NotNull String getMarca() {
        return marca;
    }

    public void setMarca(@NotBlank @NotNull String marca) {
        this.marca = marca;
    }

    public @NotBlank @NotNull String getModelo() {
        return modelo;
    }

    public void setModelo(@NotBlank @NotNull String modelo) {
        this.modelo = modelo;
    }

    public @NotBlank @NotNull String getPlaca() {
        return placa;
    }

    public void setPlaca(@NotBlank @NotNull String placa) {
        this.placa = placa;
    }

    public Conservacao getConservacao() {
        return conservacao;
    }

    public void setConservacao(Conservacao conservacao) {
        this.conservacao = conservacao;
    }

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }
}
