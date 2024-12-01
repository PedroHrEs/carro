package com.prova.carro.resources;

import com.prova.carro.domains.Carro;
import com.prova.carro.domains.dtos.CarroDTO;
import com.prova.carro.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/carro")
public class CarroResource {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<CarroDTO>> findAll() {
        return ResponseEntity.ok().body(carroService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CarroDTO> findById(@PathVariable int id) {
        Carro obj = this.carroService.findById(id);
        return ResponseEntity.ok().body(new CarroDTO(obj));
    }

    @GetMapping(value = "/placa/{placa}")
    public ResponseEntity<CarroDTO> findbyIsbn(@PathVariable String placa) {
        Carro obj = this.carroService.findByPlaca(placa);
        return ResponseEntity.ok().body(new CarroDTO(obj));
    }

    @PostMapping
    public ResponseEntity<CarroDTO> create(@Valid @RequestBody CarroDTO dto) {
        Carro carro = carroService.create(dto);
        //cria o URI para o Recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carro.getIdCarro()).toUri();
        // retorna a resposta com o status 201 create e o local do recurso criado
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<CarroDTO> update(@PathVariable Integer id, @Valid @RequestBody CarroDTO objDTO){
        Carro obj = carroService.update(id, objDTO);
        return ResponseEntity.ok().body(new CarroDTO(obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CarroDTO> delete(@PathVariable Integer id){
        carroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
