package com.proyecto2.micro01client.Controller;

import com.proyecto2.micro01client.Model.Client;
import com.proyecto2.micro01client.Service.IService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/client")
@AllArgsConstructor
public class Controller {

    private final IService iService;

    @GetMapping ( value = "/getAll", consumes = "application/json", produces = "application/json")
    public Flux<Client> getAllContacts() {
      return this.iService.getAllContacts();
    }

    @GetMapping ( value = "/getCliente/{dni}", consumes = "application/json", produces = "application/json")
    public Mono<ResponseEntity<Client>> getClient(@PathVariable String dni) {
        return this.iService.getClient(dni);
    }
    
    @PostMapping ( value = "/postCliente", consumes = "application/json", produces = "application/json")
    public Mono<ResponseEntity<Client>> insertClient(@RequestBody Client client){
        return this.iService.insertClient(client);
    }
    
    @PutMapping ( value = "/putCliente/{dni}/{email}", consumes = "application/json", produces = "application/json")
    public Mono<ResponseEntity<Client>> updateClient(@PathVariable String dni, @RequestParam String email) {
        return this.iService.updateClient(email, dni);
    }

    @DeleteMapping ( value = "/deleteCliente/{dni}", consumes = "application/json", produces = "application/json")
	public Mono<ResponseEntity<Void>>  deleteContact(@PathVariable String dni) {
        return this.iService.deleteContact(dni);
    }

}
