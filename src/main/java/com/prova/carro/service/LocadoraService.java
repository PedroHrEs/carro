package com.prova.carro.service;

import com.prova.carro.domains.Locadora;
import com.prova.carro.domains.dtos.LocadoraDTO;
import com.prova.carro.repositories.LocadoraRepository;
import com.prova.carro.service.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocadoraService {

    @Autowired
    private LocadoraRepository locadoraRepo;

    public List<LocadoraDTO> findAll() {
        return locadoraRepo.findAll().stream()
                .map(obj -> new LocadoraDTO(obj))
                .collect(Collectors.toList());
    }

    public Locadora findById(int id) {
        Optional<Locadora> obj = locadoraRepo.findById(id);
        return obj.orElse(null);
    }
    public Locadora findByCnpj(String cnpj){
        Optional<Locadora> obj = locadoraRepo.findByCnpj(cnpj);
        return obj.orElse(null);

    }
    public Locadora create(LocadoraDTO dto){
        dto.setId(null);
        validaLocadora(dto);
        Locadora obj = new Locadora(dto);
        return locadoraRepo.save(obj);
    }
    public Locadora update(Integer id, LocadoraDTO objDto){
        objDto.setId(id);
        Locadora oldObj = findById(id);
        oldObj = new Locadora(objDto);
        return locadoraRepo.save(oldObj);
    }
    public void validaLocadora(LocadoraDTO dto){
        Optional<Locadora> obj = locadoraRepo.findByCnpj(dto.getCnpj());
        if(obj.isPresent() && obj.get().getIdLocadora() != dto.getId()){
            throw new DataIntegrityViolationException("CNPJ já cadastrado!");
        }

    }
    public void delete(Integer id){
        Locadora obj = findById(id);
        if (obj.getCarros().size()>0){
            throw new DataIntegrityViolationException("Locadora não pode ser deletado pois possui Carros vinculados!");
        }
        locadoraRepo.deleteById(id);
    }

}
