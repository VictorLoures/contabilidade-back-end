package com.c.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c.domain.Funcionario;
import com.c.repositories.FuncionarioRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> findAll(){
		return funcionarioRepository.findAll();
	}

	public Funcionario findById(Integer id) throws ObjectNotFoundException {
		Optional<Funcionario> f =  funcionarioRepository.findById(id);
		return f.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
	}

	public void delete(Integer id) {
		funcionarioRepository.deleteById(id);
	}

	public void insert(Funcionario func) {
		Funcionario f = new Funcionario(null, func.getNome(), func.getCpf(), func.getTelefone(), func.getEmail(), func.getSalarioBruto());
		funcionarioRepository.save(f);
	}

	public Funcionario update(Funcionario func, Integer id) throws ObjectNotFoundException {
		Funcionario newObj = findById(id);
		updateData(newObj, func);
		return funcionarioRepository.save(newObj);
		
	}

	private void updateData(Funcionario newObj, Funcionario func) {
		Funcionario f = new Funcionario();
		f.calculos(func.getSalarioBruto());
		newObj.setValeRefeicaooAlimentacao(f.getValeRefeicaooAlimentacao());
		newObj.setValeTransporte(f.getValeTransporte());
		newObj.setInss(f.getInss());
		newObj.setIrrf(f.getIrrf());
		newObj.setSalarioTotal(f.getSalarioTotal());
		newObj.setNome(func.getNome());
		newObj.setCpf(func.getCpf());
		newObj.setTelefone(func.getTelefone());
		newObj.setEmail(func.getEmail());
		newObj.setSalarioBruto(func.getSalarioBruto());
		
		
	}
	

}
