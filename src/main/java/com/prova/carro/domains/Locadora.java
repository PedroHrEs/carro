package com.prova.carro.domains;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.prova.carro.domains.dtos.LocadoraDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "locadora")
public class Locadora {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_locadora")
    private Integer idLocadora;

    @NotBlank
    @NotNull
    private String nomeLocadora;

    @NotBlank
    @NotNull
    @Column(unique = true)
    private String cnpj;

    @JsonManagedReference
    @OneToMany(mappedBy = "locadora")
    private List<Carro> carros = new ArrayList<>();

    public Locadora() {
    }

    public Locadora(Integer idLocadora, String nomeLocadora, String cnpj) {
        this.idLocadora = idLocadora;
        this.nomeLocadora = nomeLocadora;
        this.cnpj = cnpj;
    }

    public Locadora(LocadoraDTO dto) {
        this.idLocadora = dto.getId();
        this.nomeLocadora = dto.getNome();
        this.cnpj = dto.getCnpj();

    }

    public Integer getIdLocadora() {
        return idLocadora;
    }

    public void setIdLocadora(Integer idLocadora) {
        this.idLocadora = idLocadora;
    }

    public @NotBlank @NotNull String getNomeLocadora() {
        return nomeLocadora;
    }

    public void setNomeLocadora(@NotBlank @NotNull String nomeLocadora) {
        this.nomeLocadora = nomeLocadora;
    }

    public @NotBlank @NotNull String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotBlank @NotNull String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locadora locadora = (Locadora) o;
        return Objects.equals(idLocadora, locadora.idLocadora) && Objects.equals(nomeLocadora, locadora.nomeLocadora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLocadora, nomeLocadora);
    }
}
