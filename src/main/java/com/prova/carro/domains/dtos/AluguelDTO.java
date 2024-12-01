package com.prova.carro.domains.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.prova.carro.domains.Aluguel;
import com.prova.carro.domains.Cliente;
import com.prova.carro.domains.enums.Situacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class AluguelDTO {

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;

    @NotNull(message = "O campo Comprovante Reserva não pode ser nulo!")
    @NotBlank(message = "O campo nome não pode ser vazio!")
    private String comprovanteReserva;

    @NotNull(message = "O campo valorAluguel não pode ser nulo!")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal valorAluguel;

    @NotNull(message = "O campo cliente não pode ser nulo!")
    private int cliente;
    private String nomeCliente;
    private String cpfCliente;
    private String cnhCliente;
    private String emailCliente;

    @NotNull(message = "O campo Carro não pode ser nulo")
    private int carro;
    private String marcaCarro;
    private String modeloCarro;
    private String placaCarro;
    private int conservacaoCarro;

    private int situacao;

    public AluguelDTO(Aluguel aluguel) {
        this.id = aluguel.getId();
        this.dataInicio = aluguel.getDataInicio();
        this.dataFim = aluguel.getDataFim();
        this.comprovanteReserva = aluguel.getComprovanteReserva();
        this.valorAluguel = aluguel.getValorAluguel();
        this.cliente = aluguel.getCliente().getId();
        this.nomeCliente = aluguel.getCliente().getNomeCliente();
        this.cpfCliente = aluguel.getCliente().getCpf();
        this.cnhCliente = aluguel.getCliente().getCnh();
        this.emailCliente = aluguel.getCliente().getEmail();
        this.situacao = aluguel.getSituacao().getId();
        this.carro = aluguel.getCarro().getIdCarro();
        this.marcaCarro = aluguel.getCarro().getMarca();
        this.modeloCarro = aluguel.getCarro().getModelo();
        this.placaCarro = aluguel.getCarro().getPlaca();
        this.conservacaoCarro = aluguel.getCarro().getConservacao().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public @NotNull(message = "O campo Comprovante Reserva não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String getComprovanteReserva() {
        return comprovanteReserva;
    }

    public void setComprovanteReserva(@NotNull(message = "O campo Comprovante Reserva não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String comprovanteReserva) {
        this.comprovanteReserva = comprovanteReserva;
    }

    public @NotNull(message = "O campo valorAluguel não pode ser nulo!") @Digits(integer = 15, fraction = 3) BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(@NotNull(message = "O campo valorAluguel não pode ser nulo!") @Digits(integer = 15, fraction = 3) BigDecimal valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    @NotNull(message = "O campo cliente não pode ser nulo!")
    public int getCliente() {
        return cliente;
    }

    public void setCliente(@NotNull(message = "O campo cliente não pode ser nulo!") int cliente) {
        this.cliente = cliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getCnhCliente() {
        return cnhCliente;
    }

    public void setCnhCliente(String cnhCliente) {
        this.cnhCliente = cnhCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    @NotNull(message = "O campo Carro não pode ser nulo")
    public int getCarro() {
        return carro;
    }

    public void setCarro(@NotNull(message = "O campo Carro não pode ser nulo") int carro) {
        this.carro = carro;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
}
