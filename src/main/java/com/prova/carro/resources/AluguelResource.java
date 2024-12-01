package com.prova.carro.resources;

import com.prova.carro.domains.Aluguel;
import com.prova.carro.domains.dtos.AluguelDTO;
import com.prova.carro.service.AluguelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/aluguel")
public class AluguelResource {

    @Autowired
    private AluguelService aluguelService;

    @GetMapping
    public ResponseEntity<List<AluguelDTO>> findAll() {
        return ResponseEntity.ok().body(aluguelService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AluguelDTO> findById(@PathVariable int id) {
        Aluguel obj = this.aluguelService.findById(id);
        return ResponseEntity.ok().body(new AluguelDTO(obj));
    }

    @GetMapping(value = "/comprovantereserva/{comprovantereserva}")
    public ResponseEntity<AluguelDTO> findByComprovanteReserva(@PathVariable String comprovanteReserva) {
        Aluguel obj = this.aluguelService.findbyComprovanteReserva(comprovanteReserva);
        return ResponseEntity.ok().body(new AluguelDTO(obj));
    }

    @PostMapping
    public ResponseEntity<AluguelDTO> create(@Valid @RequestBody AluguelDTO dto) {
        Aluguel aluguel = aluguelService.create(dto);
        //cria o URI para o Recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluguel.getId()).toUri();
        // retorna a resposta com o status 201 create e o local do recurso criado
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<AluguelDTO> update(@PathVariable Integer id, @Valid @RequestBody AluguelDTO objDTO){
        Aluguel obj = aluguelService.update(id, objDTO);
        return ResponseEntity.ok().body(new AluguelDTO(obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AluguelDTO> delete(@PathVariable Integer id){
        aluguelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
