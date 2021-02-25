package com.c.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private Double salarioBruto;
	private Double valeTransporte;
	private Double valeAlimentacao;
	private Double inss;
	private Double irrf;
	private Double salarioTotal;
	
	public Funcionario(Integer id, String nome, String cpf, String telefone, String email, Double salarioBruto) {
			
			this.id = id;
			this.nome = nome;
			this.cpf = cpf;
			this.telefone = telefone;
			this.email = email;
			calculos(salarioBruto);
			
	}

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(Double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public Double getValeTransporte() {
		return valeTransporte;
	}

	public void setValeTransporte(Double valeTransporte) {
		this.valeTransporte = valeTransporte;
	}

	public Double getValeRefeicaooAlimentacao() {
		return valeAlimentacao;
	}

	public void setValeRefeicaooAlimentacao(Double valeRefeicaooAlimentacao) {
		this.valeAlimentacao = valeRefeicaooAlimentacao;
	}

	public Double getInss() {
		return inss;
	}

	public void setInss(Double inss) {
		this.inss = inss;
	}

	public Double getIrrf() {
		return irrf;
	}

	public void setIrrf(Double irrf) {
		this.irrf = irrf;
	}

	public Double getSalarioTotal() {
		return salarioTotal;
	}

	public void setSalarioTotal(Double salarioTotal) {
		this.salarioTotal = salarioTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public void calculos(double salario) {
		this.salarioBruto = salario;
		//para saber o desconto da passagem
		double salarioBrutoInteiroPassagem = salarioBruto;
		//para saber o desconto da alimentacao
		double salarioBrutoInteiroAlimentacao = salarioBruto;
		//valor de quanto e gasto em passagens
		double passagens = (2 * 3.75) * 21;
		//6% do salario bruto
		double porcentagemSalario = salarioBruto * 0.06;
		
		if(porcentagemSalario > passagens) {
			salarioBrutoInteiroPassagem = salarioBruto - (salarioBrutoInteiroPassagem - porcentagemSalario);
			this.valeTransporte = salarioBrutoInteiroPassagem;
		}else {
			salarioBrutoInteiroPassagem = salarioBruto - (salarioBruto - passagens);
			this.valeTransporte = salarioBrutoInteiroPassagem;
		}
		
		salarioBrutoInteiroAlimentacao =(salarioBrutoInteiroAlimentacao * 0.05);
		this.valeAlimentacao = salarioBrutoInteiroAlimentacao;
			
		double desc = 0.0;
		double salarioInss = 0.0;
		double salarioIrrf = 0.0;
		//INSS
		if(salarioBruto <= 1100) {
			desc = salarioBruto * 0.075;
			salarioInss =  desc;
			this.inss = salarioInss;
		}else if(salarioBruto >= 1100.01 && salarioBruto <= 2203.48) {
			desc = salarioBruto * 0.09;
			salarioInss = desc;
			this.inss = salarioInss;
			
		}else if(salarioBruto >= 2203.49 && salarioBruto <= 3305.22) {
			desc = salarioBruto * 0.12;
			salarioInss = desc;
			this.inss = salarioInss;
			
		}else if(salarioBruto >= 3305.23 && salarioBruto <= 6433.57) {
			desc = (salarioBruto / 100) * 14;
			salarioInss =  desc;
			this.inss = salarioInss;
			
		}else if(salarioBruto > 6433.57){
			desc = (salarioBruto / 100) * 14;
			salarioInss =  desc;
			this.inss = salarioInss;
			//IRRF
		}
		
		if(salarioBruto <= 1100) {
			desc = salarioBruto * 0.075;
			salarioIrrf =  desc;
			this.irrf = salarioIrrf;
		}else if(salarioBruto >= 1100.01 && salarioBruto <= 2203.48) {
			desc = salarioBruto * 0.075;
			salarioIrrf =  desc;
			this.irrf = salarioIrrf;
			
		}else if(salarioBruto >= 2203.49 && salarioBruto <= 3305.22) {
			desc = salarioBruto * 0.12;
			salarioIrrf =  desc;
			this.irrf = salarioIrrf;
			
		}else if(salarioBruto >= 3305.23 && salarioBruto <= 6433.57) {
			desc = (salarioBruto / 100) * 14;
			salarioIrrf =  desc;
			this.irrf = salarioIrrf;
			
		}else {
			desc = (salarioBruto / 100) * 14;
			salarioIrrf =  desc;
			this.irrf = salarioIrrf;
		}
		
		this.salarioTotal = (salarioBruto - salarioBrutoInteiroAlimentacao - salarioBrutoInteiroPassagem - salarioInss - salarioIrrf);
	}
	
}
