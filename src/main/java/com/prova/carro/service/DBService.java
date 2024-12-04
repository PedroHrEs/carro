package com.prova.carro.service;


import com.prova.carro.domains.Aluguel;
import com.prova.carro.domains.Carro;
import com.prova.carro.domains.Cliente;
import com.prova.carro.domains.Locadora;
import com.prova.carro.domains.enums.Conservacao;
import com.prova.carro.domains.enums.Situacao;
import com.prova.carro.repositories.AluguelRepository;
import com.prova.carro.repositories.CarroRepository;
import com.prova.carro.repositories.ClienteRepository;
import com.prova.carro.repositories.LocadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private AluguelRepository aluguelRepo;

    @Autowired
    private CarroRepository carroRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private LocadoraRepository locadoraRepo;

    public void initDB(){

        Cliente cliente01 = new Cliente(null,"pedro", "12322", "11212", "pedro@email");
        Cliente cliente02 = new Cliente(null,"paulo", "11102", "11123", "paulo@email");

        Locadora locadora01 = new Locadora(null, "alugaveiculos", "222321");

        Carro carro01 = new Carro(null, "volks", "gol", "as1234", Conservacao.NOVO, locadora01);
        Carro carro02 = new Carro(null, "volks", "golf", "ap2125", Conservacao.USADO, locadora01);

        Aluguel aluguel01 = new Aluguel(null, LocalDate.now(),null, "123123232", new BigDecimal("120.00"), Situacao.ANDAMENTO, cliente01, carro01);

        clienteRepo.save(cliente01);
        clienteRepo.save(cliente02);
        locadoraRepo.save(locadora01);
        carroRepo.save(carro01);
        carroRepo.save(carro02);
        aluguelRepo.save(aluguel01);
    }
}
