package com.bankapp.bank;

import com.bankapp.bank.Models.Clients;
import com.bankapp.bank.Repository.ClientsRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
class BankApplicationTests {


	@Autowired
	private ClientsRepository repo;

	@Test
	public void createUserTest() {

		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);


		Clients us = new Clients();
		us.setId_client(9L);
		us.setName_client("lolito");
		us.setSurname_client("fedez");
		us.setPhone_client("25252525");
		us.setEmail_client("kodigo@gmail.com");
		us.setDni_client("98743690-6");
		us.setUser_client("lotso");

		us.setPassword_client("345");
		String hash = argon2.hash(1,1024,1,us.getPassword_client());
		us.setPassword_client(hash);

		us.setId_statusclient(1);

		Clients retorno = repo.save(us);

		assertTrue(retorno.getPassword_client().equalsIgnoreCase(us.getPassword_client()));





	}
}
