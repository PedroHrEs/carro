package com.prova.carro.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.prova.carro.domains.dtos.ClienteDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
    private Integer id;

    @NotNull
    @NotBlank
    private String nomeCliente;

    @NotBlank
    @NotNull
    @Column(unique = true)
    private String cpf;

    @NotBlank
    @NotNull
    @Column(unique = true)
    private String cnh;

    @NotBlank
    @NotNull
    @Column(unique = true)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Aluguel> alugueis = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(Integer id, String nomeCliente, String cpf, String cnh, String email) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.cnh = cnh;
        this.email = email;
    }

    public Cliente(ClienteDTO dto){
        this.id = dto.getId();
        this.nomeCliente = dto.getNome();
        this.cpf = dto.getCpf();
        this.cnh = dto.getCnh();
        this.email = dto.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(@NotNull @NotBlank String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public @NotBlank @NotNull String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank @NotNull String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank @NotNull String getCnh() {
        return cnh;
    }

    public void setCnh(@NotBlank @NotNull String cnh) {
        this.cnh = cnh;
    }

    public @NotBlank @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @NotNull String email) {
        this.email = email;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nomeCliente, cliente.nomeCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeCliente);
    }
}
