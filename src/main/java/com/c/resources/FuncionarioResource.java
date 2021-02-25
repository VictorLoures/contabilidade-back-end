package com.c.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c.domain.Funcionario;
import com.c.service.FuncionarioService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioService funcService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Funcionario>> findAll() throws ObjectNotFoundException{
		List<Funcionario> obj = funcService.findAll();
		return ResponseEntity.ok().body(obj);
	}

}
