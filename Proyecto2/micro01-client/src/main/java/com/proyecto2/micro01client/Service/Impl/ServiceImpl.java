package com.proyecto2.micro01client.Service.Impl;


import com.proyecto2.micro01client.Dao.IDao;
import com.proyecto2.micro01client.Exception.NotFoundException;
import com.proyecto2.micro01client.Model.Client;
import com.proyecto2.micro01client.Service.IService;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ServiceImpl implements IService {

	private final IDao iDao;
	@Override
	public Mono<ResponseEntity<Void>>  deleteContact(String dni) {
		return this.iDao.findById(dni)
				.flatMap(obj ->
						iDao.delete(obj)
								.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
				)
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@Override
	public Flux<Client> getAllContacts() {
		return this.iDao.findAll();
	}

	@Override
	public Mono<ResponseEntity<Client>> getClient(String dni) {
		if (dni.length() == 8) {
            return this.iDao.findById(dni)
                    .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                    .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		}
        throw new NotFoundException("El id debe ser de 8 caracteres");
	}

	@Override
	public Mono<ResponseEntity<Client>> insertClient(Client client) {

		List<String> types = List.of("Personal", "Empresarial");

		if (!types.contains(client.getTypeAccount())) {
			throw new NotFoundException("Tipo de cuenta invalido");
		}

		client.setDateRegister(LocalDateTime.now());
		return this.iDao.insert(client)
		.map(cli -> new ResponseEntity<>(cli, HttpStatus.ACCEPTED))
		.defaultIfEmpty(new ResponseEntity<>(client, HttpStatus.NOT_ACCEPTABLE));
	}

	@Override
	public Mono<ResponseEntity<Client>> updateClient(String email, String dni) {
		return this.iDao.findById(dni)
		.flatMap(client -> {
		  client.setEmail(email);
		  return this.iDao.save(client)
			.map(clientSave -> new ResponseEntity<>(clientSave, HttpStatus.ACCEPTED));
		}).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}