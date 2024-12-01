package com.prova.carro.domains.dtos;

import com.prova.carro.domains.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteDTO {

    private Integer id;

    @NotNull(message = "O campo nome não pode ser nulo!")
    @NotBlank(message = "O campo nome não pode ser vazio!")
    private String nome;

    @NotNull(message = "O campo cpf não pode ser nulo!")
    @NotBlank(message = "O campo cpf não pode ser vazio!")
    private String cpf;

    @NotNull(message = "O campo cnh não pode ser nulo!")
    @NotBlank(message = "O campo cnh não pode ser vazio!")
    private String cnh;

    @NotNull(message = "O campo email não pode ser nulo!")
    @NotBlank(message = "O campo email não pode ser vazio!")
    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNomeCliente();
        this.cpf = cliente.getCpf();
        this.cnh = cliente.getCnh();
        this.email = cliente.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo cpf não pode ser nulo!") @NotBlank(message = "O campo cpf não pode ser vazio!") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull(message = "O campo cpf não pode ser nulo!") @NotBlank(message = "O campo cpf não pode ser vazio!") String cpf) {
        this.cpf = cpf;
    }

    public @NotNull(message = "O campo cnh não pode ser nulo!") @NotBlank(message = "O campo cnh não pode ser vazio!") String getCnh() {
        return cnh;
    }

    public void setCnh(@NotNull(message = "O campo cnh não pode ser nulo!") @NotBlank(message = "O campo cnh não pode ser vazio!") String cnh) {
        this.cnh = cnh;
    }

    public @NotNull(message = "O campo email não pode ser nulo!") @NotBlank(message = "O campo email não pode ser vazio!") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "O campo email não pode ser nulo!") @NotBlank(message = "O campo email não pode ser vazio!") String email) {
        this.email = email;
    }
}
