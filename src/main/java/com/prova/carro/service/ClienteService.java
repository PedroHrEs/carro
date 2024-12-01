package com.prova.carro.service;

import com.prova.carro.domains.Cliente;
import com.prova.carro.domains.dtos.ClienteDTO;
import com.prova.carro.repositories.ClienteRepository;
import com.prova.carro.service.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepo;

    public List<ClienteDTO> findAll(){
        return clienteRepo.findAll().stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
    }
    public Cliente findById(Integer id){
        Optional<Cliente> obj = clienteRepo.findById(id);
        return obj.orElse(null);
    }

    public Cliente findByCpf(String cpf){
        Optional<Cliente> obj = clienteRepo.findByCpf(cpf);
        return obj.orElse(null);

    }
    public Cliente findByCnh(String cnh){
        Optional<Cliente> obj = clienteRepo. findByCnh(cnh);
        return obj.orElse(null);
    }
    public Cliente findByEmail(String email){
        Optional<Cliente> obj = clienteRepo.findByEmail(email);
        return obj.orElse(null);
    }
    public Cliente create(ClienteDTO dto){
        dto.setId(null);
        Cliente obj = new Cliente(dto);
        return clienteRepo.save(obj);
    }
    public Cliente update(Integer id, ClienteDTO objDto){
        objDto.setId(id);
        Cliente oldObj = findById(id);
        oldObj = new Cliente(objDto);
        return clienteRepo.save(oldObj);
    }
    public void delete(Integer id){
        Cliente obj = findById(id);
        if (obj.getAlugueis().size()>0){
            throw new DataIntegrityViolationException("Cliente não pode ser deletado pois possui alugueis vinculados!");
        }
        clienteRepo.deleteById(id);
    }

}
