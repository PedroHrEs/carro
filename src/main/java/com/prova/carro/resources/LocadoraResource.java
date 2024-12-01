package com.prova.carro.resources;

import com.prova.carro.domains.Locadora;
import com.prova.carro.domains.dtos.LocadoraDTO;
import com.prova.carro.service.LocadoraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/locadora")
public class LocadoraResource {

    @Autowired
    private LocadoraService locadoraService;

    @GetMapping
    public ResponseEntity<List<LocadoraDTO>> findAll() {
        return ResponseEntity.ok().body(locadoraService.findAll());
    }

    @GetMapping(value = "/{idLocadora}")
    public ResponseEntity<LocadoraDTO> findById(@PathVariable int id) {
        Locadora obj = this.locadoraService.findById(id);
        return ResponseEntity.ok().body(new LocadoraDTO(obj));
    }

    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<LocadoraDTO> findByCnpj(@PathVariable String cnpj) {
        Locadora obj = this.locadoraService.findByCnpj(cnpj);
        return ResponseEntity.ok().body(new LocadoraDTO(obj));
    }

    @PostMapping
    public ResponseEntity<LocadoraDTO> create(@Valid @RequestBody LocadoraDTO dto) {
        Locadora locadora = locadoraService.create(dto);
        //cria o URI para o Recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(locadora.getIdLocadora()).toUri();
        // retorna a resposta com o status 201 create e o local do recurso criado
        return ResponseEntity.created(uri).build();
    }
    @PutMapping
    public ResponseEntity<LocadoraDTO> update(@PathVariable Integer id, @Valid @RequestBody LocadoraDTO objDto){
        Locadora obj = locadoraService.update(id, objDto);
        return ResponseEntity.ok().body(new LocadoraDTO(obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<LocadoraDTO> delete (@PathVariable Integer id){
        locadoraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
