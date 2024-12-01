package com.prova.carro.repositories;

import com.prova.carro.domains.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {
    Optional<Carro> findByPlaca(String placa);
}
