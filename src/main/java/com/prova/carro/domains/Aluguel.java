package com.prova.carro.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.prova.carro.domains.dtos.AluguelDTO;
import com.prova.carro.domains.enums.Situacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "aluguel")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_aluguel")
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;

    @NotBlank
    @NotNull
    @Column(unique = true)
    private String comprovanteReserva;

    @NotNull
    @Digits(integer = 15, fraction = 3)
    private BigDecimal valorAluguel;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "situacao")
    private Situacao situacao;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idcarro")
    private Carro carro;

    public Aluguel() {
        this.situacao = Situacao.ANDAMENTO;
        this.valorAluguel = BigDecimal.ZERO;
    }

    public Aluguel(Integer id, LocalDate dataInicio, LocalDate dataFim, String comprovanteReserva, BigDecimal valorAluguel, Situacao situacao, Cliente cliente, Carro carro) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.comprovanteReserva = comprovanteReserva;
        this.valorAluguel = valorAluguel;
        this.situacao = situacao;
        this.cliente = cliente;
        this.carro = carro;
    }

    public Aluguel(AluguelDTO dto){
        this.id = dto.getId();
        this.dataInicio = dto.getDataInicio();
        this.dataFim = dto.getDataFim();
        this.comprovanteReserva = dto.getComprovanteReserva();
        this.valorAluguel = dto.getValorAluguel().setScale(2,BigDecimal.ROUND_HALF_UP);
        this.situacao = Situacao.toEnum(dto.getSituacao());

        this.cliente = new Cliente();
        this.cliente.setId(dto.getCliente());

        this.carro = new Carro();
        this.carro.setIdCarro(dto.getCarro());
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

    public @NotBlank @NotNull String getComprovanteReserva() {
        return comprovanteReserva;
    }

    public void setComprovanteReserva(@NotBlank @NotNull String comprovanteReserva) {
        this.comprovanteReserva = comprovanteReserva;
    }

    public @NotNull @Digits(integer = 15, fraction = 3) BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(@NotNull @Digits(integer = 15, fraction = 3) BigDecimal valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
