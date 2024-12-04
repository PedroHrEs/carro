package com.prova.carro.service;

import com.prova.carro.domains.Carro;
import com.prova.carro.domains.Locadora;
import com.prova.carro.domains.dtos.CarroDTO;
import com.prova.carro.repositories.CarroRepository;
import com.prova.carro.repositories.LocadoraRepository;
import com.prova.carro.service.exceptions.DataIntegrityViolationException;
import com.prova.carro.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepo;

    @Autowired
    private LocadoraRepository locadoraRepo;


    public List<CarroDTO> findAll() {
        return carroRepo.findAll().stream()
                .map(obj -> new CarroDTO(obj))
                .collect(Collectors.toList());
    }

    public Carro findById(Integer id) {
        Optional<Carro> obj = carroRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado! Id: "+id));
    }

    public Carro findByPlaca(String placa) {
        Optional<Carro> obj = carroRepo.findByPlaca(placa);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado! Placa: "+placa));
    }

    public Carro create(CarroDTO dto) {
        dto.setId(null);
        validaCarro(dto);
        Carro obj = new Carro(dto);
        return carroRepo.save(obj);
    }

    public void validaCarro(CarroDTO dto) {
        Optional<Carro> obj = carroRepo.findByPlaca(dto.getPlaca());
        if (obj.isPresent() && obj.get().getIdCarro() != dto.getId()) {
            throw new DataIntegrityViolationException("Placa já cadastrada!");
        }

        Optional<Locadora> locadora = locadoraRepo.findById(dto.getLocadora());
        if (!locadora.isPresent()) {
            throw new DataIntegrityViolationException("Locadora - " + dto.getLocadora() + " não está cadastrada!");
        }

    }
    public Carro update(Integer id, CarroDTO objDto){
        objDto.setId(id);
        Carro oldObj = findById(id);
        validaCarro(objDto);
        oldObj = new Carro(objDto);
        return carroRepo.save(oldObj);
    }
    public void delete (Integer id){
        Carro obj = findById(id);
        carroRepo.deleteById(id);
    }
}
