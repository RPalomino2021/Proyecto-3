package com.proyecto2.micro01client.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="clients")
public class Client {

	@Id
	private String dni;
	private String names;
	@Email(message = "Email.client.email")
	private String email;
	private String typeAccount;
	@JsonFormat(pattern = "dd:MM:yyyy KK:mm a")
	private LocalDateTime dateRegister;

}
