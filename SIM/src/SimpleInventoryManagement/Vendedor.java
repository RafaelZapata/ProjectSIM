package SimpleInventoryManagement;

public class Vendedor extends Funcionario{
	
	private int codigoVendedor;
	
//	public Vendedor(String nome, String cpf, float salario, Vendas venda, int codigoVendedor) {
//		super(nome, cpf, salario, venda);
//		this.setCodigoVendedor(codigoVendedor);
//	}
	
	public int getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

//	Método herdado da classe abstrata Funcionario
	@Override
	public double calcularComissao(Vendas venda) {
		double comissao = venda.calcularValor() * 0.10;
		return comissao;
	}

//	Método herdado da classe abstrata Funcionario
	@Override
	public String dadosFuncionario() {
		String mensagem = "\n";
		mensagem += "Nome: "+this.getNome()+"\nCPF: "+this.getCpf()+
				"\nSalario: R$"+this.calcularSalario();
		return mensagem;
	}

	@Override
	public void novo_cadastro() {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setCodigoVendedor(codigoVendedor);
		this.setSalario(salario);
		this.setVenda(venda);
		
	}
	
	
}
