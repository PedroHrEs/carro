package com.prova.carro.resources;

import com.prova.carro.domains.Cliente;
import com.prova.carro.domains.dtos.ClienteDTO;
import com.prova.carro.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){

        return ResponseEntity.ok().body(clienteService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable int id){
        Cliente obj = this.clienteService.findById(id);
        return ResponseEntity.ok().body(new ClienteDTO(obj));
    }
    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<ClienteDTO> findByCpf(@PathVariable String cpf) {
        Cliente obj = this.clienteService.findByCpf(cpf);
        return ResponseEntity.ok().body(new ClienteDTO(obj));
    }
    @GetMapping(value = "/cnh/{cnh}")
    public ResponseEntity<ClienteDTO> findByCnh(@PathVariable String cnh) {
        Cliente obj = this.clienteService.findByCnh(cnh);
        return ResponseEntity.ok().body(new ClienteDTO(obj));
    }
    @GetMapping(value = "/email/{email}")
    public ResponseEntity<ClienteDTO> findByEmail(@PathVariable String email) {
        Cliente obj = this.clienteService.findByEmail(email);
        return ResponseEntity.ok().body(new ClienteDTO(obj));
    }
    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO dto){
        Cliente cliente = clienteService.create(dto);
        //cria o URI para o Recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        // retorna a resposta com o status 201 create e o local do recurso criado
        return ResponseEntity.created(uri).build();
    }
    @PutMapping
    public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO objDto){
        Cliente obj = clienteService.update(id, objDto);
        return ResponseEntity.ok().body(new ClienteDTO(obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> delete (@PathVariable Integer id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
