package SimpleInventoryManagement;

public abstract class Funcionario implements iCadastrar{
	protected  String nome, cpf;
	protected float salario;
	protected Vendas venda;	
	
//	public Funcionario(String nome, String cpf, float salario, Vendas venda) {
//		this.setNome(nome);
//		this.setCpf(cpf);
//		this.setSalario(salario);
//		this.setVenda(venda);
//	}
	
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
	
	public float getSalario() {
		return salario;
	}
	
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public Vendas getVenda() {
		return venda;
	}

	public void setVenda(Vendas venda) {
		this.venda = venda;
	}
	
//	Métodos abstratos que as classes terão de implementar
	public abstract double calcularComissao(Vendas venda);
	public abstract String dadosFuncionario();
	
	public double calcularSalario() {
		return this.getSalario() + this.calcularComissao(venda);
	}
}
