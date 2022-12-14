package com.proyecto2.micro01client.Service;

import com.proyecto2.micro01client.Model.Client;
import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IService {

	Flux<Client> getAllContacts();

	Mono<ResponseEntity<Client>> getClient(String dni);

	Mono<ResponseEntity<Client>> insertClient(Client client);

	Mono<ResponseEntity<Client>> updateClient(String email, String dni);

	Mono<ResponseEntity<Void>> deleteContact(String dni);

}