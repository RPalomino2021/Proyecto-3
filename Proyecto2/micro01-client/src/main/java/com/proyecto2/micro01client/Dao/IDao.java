package com.proyecto2.micro01client.Dao;

import com.proyecto2.micro01client.Model.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface IDao extends ReactiveMongoRepository<Client, String> {
}
