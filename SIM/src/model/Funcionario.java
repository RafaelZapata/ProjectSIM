package model;

public abstract class Funcionario{
	protected  String nome, cpf;
	protected Vendas atRefVenda;	
	
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
	
	public Vendas getAtRefVenda() {
		return atRefVenda;
	}

	public void setAtRefVenda(Vendas atRefVenda) {
		this.atRefVenda = atRefVenda;
	}
}
