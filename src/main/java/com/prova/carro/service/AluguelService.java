package com.prova.carro.service;

import com.prova.carro.domains.Aluguel;
import com.prova.carro.domains.Carro;
import com.prova.carro.domains.Cliente;
import com.prova.carro.domains.Locadora;
import com.prova.carro.domains.dtos.AluguelDTO;
import com.prova.carro.repositories.AluguelRepository;
import com.prova.carro.repositories.CarroRepository;
import com.prova.carro.repositories.ClienteRepository;
import com.prova.carro.service.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private CarroRepository carroRepo;


    public List<AluguelDTO> findAll() {
        return aluguelRepo.findAll().stream()
                .map(obj -> new AluguelDTO(obj))
                .collect(Collectors.toList());
    }

    public Aluguel findById(Integer id) {
        Optional<Aluguel> obj = aluguelRepo.findById(id);
        return obj.orElse(null);
    }

    public Aluguel findbyComprovanteReserva(String comprovanteReserva) {
        Optional<Aluguel> obj = aluguelRepo.findByComprovanteReserva(comprovanteReserva);
        return obj.orElse(null);
    }

    public Aluguel create(AluguelDTO dto) {
        dto.setId(null);
        validaAluguel(dto);
        Aluguel obj = new Aluguel(dto);
        return aluguelRepo.save(obj);
    }

    public void validaAluguel(AluguelDTO dto) {
        Optional<Aluguel> obj = aluguelRepo.findByComprovanteReserva(dto.getComprovanteReserva());
        if (obj.isPresent() && obj.get().getId() != dto.getId()) {
            throw new DataIntegrityViolationException("Comprovante Reserva já cadastrado!");
        }

        Optional<Cliente> cliente = clienteRepo.findById(dto.getCliente());
        if (!cliente.isPresent()) {
            throw new DataIntegrityViolationException("Cliente - " + dto.getCliente() + " não está cadastrado!");
        }
        Optional<Carro> carro = carroRepo.findById(dto.getCarro());
        if (!carro.isPresent()) {
            throw new DataIntegrityViolationException("Carro - " + dto.getCarro() + " não está cadastrado!");
        }
    }
    public Aluguel update(Integer id, AluguelDTO objDto){
        objDto.setId(id);
        Aluguel oldObj = findById(id);
        validaAluguel(objDto);
        oldObj = new Aluguel(objDto);
        return aluguelRepo.save(oldObj);
    }
    public void delete (Integer id){
        Aluguel obj = findById(id);
        aluguelRepo.deleteById(id);
    }
}
