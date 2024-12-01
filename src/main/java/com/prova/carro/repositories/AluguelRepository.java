package com.prova.carro.repositories;

import com.prova.carro.domains.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Integer> {

    Optional findByComprovanteReserva(String comprovanteReserva);
}
