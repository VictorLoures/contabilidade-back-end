package com.c;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.c.domain.Funcionario;
import com.c.repositories.FuncionarioRepository;

@SpringBootApplication
public class ContabilidadeApplication implements CommandLineRunner {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ContabilidadeApplication.class, args);
	}
	
	public void run(String ... args) {
		
		Funcionario func1 = new Funcionario(null, "Victor de Freitas Loures", "15673311656", "(32) 98848-9079"
				, "victorloures10@gmail.com", 4000.00);
		Funcionario func2 = new Funcionario(null, "Erica Aparecida de Freitas Loures", "03438939673", "(32) 98848-9079"
				, "victorloures10@gmail.com", 1100.00);
		
		funcionarioRepository.saveAll(Arrays.asList(func1, func2));
		
	}

}
