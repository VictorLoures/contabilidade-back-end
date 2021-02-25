package com.c.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<Funcionario> findById(@PathVariable Integer id) throws ObjectNotFoundException{
		Funcionario obj = funcService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) throws ObjectNotFoundException{
		funcService.delete(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void inserir(@Validated @RequestBody Funcionario func) throws ObjectNotFoundException{
		funcService.insert(func);
		
	}
	
	@RequestMapping(value = "/{id}" ,method=RequestMethod.PUT)
	public void update(@Validated @RequestBody Funcionario func, @PathVariable Integer id ) throws ObjectNotFoundException{
	 funcService.update(func, id);
	}

}
