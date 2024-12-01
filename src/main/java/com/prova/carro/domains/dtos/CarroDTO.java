package com.prova.carro.domains.dtos;

import com.prova.carro.domains.Carro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CarroDTO {

    private Integer id;

    @NotNull(message = "O campo marca não pode ser nulo!")
    @NotBlank(message = "O campo marca não pode ser vazio!")
    private String marca;

    @NotNull(message = "O campo modelo não pode ser nulo!")
    @NotBlank(message = "O campo modelo não pode ser vazio!")
    private String modelo;

    @NotNull(message = "O campo placa não pode ser nulo!")
    @NotBlank(message = "O campo placa não pode ser vazio!")
    private String placa;

    @NotNull(message = "O campo Locadora não pode ser nulo!")
    private int locadora;
    private String nomeLocadora;
    private String cnpjLocadora;

    private int Conservacao;

    public CarroDTO() {
    }

    public CarroDTO(Carro carro) {
        this.id = carro.getIdCarro();
        this.marca = carro.getMarca();
        this.modelo = carro.getModelo();
        this.placa = carro.getPlaca();
        this.locadora = carro.getLocadora().getIdLocadora();
        this.nomeLocadora = carro.getLocadora().getNomeLocadora();
        this.cnpjLocadora = carro.getLocadora().getCnpj();
        this.Conservacao = carro.getConservacao().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "O campo marca não pode ser nulo!") @NotBlank(message = "O campo marca não pode ser vazio!") String getMarca() {
        return marca;
    }

    public void setMarca(@NotNull(message = "O campo marca não pode ser nulo!") @NotBlank(message = "O campo marca não pode ser vazio!") String marca) {
        this.marca = marca;
    }

    public @NotNull(message = "O campo modelo não pode ser nulo!") @NotBlank(message = "O campo modelo não pode ser vazio!") String getModelo() {
        return modelo;
    }

    public void setModelo(@NotNull(message = "O campo modelo não pode ser nulo!") @NotBlank(message = "O campo modelo não pode ser vazio!") String modelo) {
        this.modelo = modelo;
    }

    public @NotNull(message = "O campo placa não pode ser nulo!") @NotBlank(message = "O campo placa não pode ser vazio!") String getPlaca() {
        return placa;
    }

    public void setPlaca(@NotNull(message = "O campo placa não pode ser nulo!") @NotBlank(message = "O campo placa não pode ser vazio!") String placa) {
        this.placa = placa;
    }

    @NotNull(message = "O campo Locadora não pode ser nulo!")
    public int getLocadora() {
        return locadora;
    }

    public void setLocadora(@NotNull(message = "O campo Locadora não pode ser nulo!") int locadora) {
        this.locadora = locadora;
    }

    public String getNomeLocadora() {
        return nomeLocadora;
    }

    public void setNomeLocadora(String nomeLocadora) {
        this.nomeLocadora = nomeLocadora;
    }

    public String getCnpjLocadora() {
        return cnpjLocadora;
    }

    public void setCnpjLocadora(String cnpjLocadora) {
        this.cnpjLocadora = cnpjLocadora;
    }

    public int getConservacao() {
        return Conservacao;
    }

    public void setConservacao(int conservacao) {
        Conservacao = conservacao;
    }
}
