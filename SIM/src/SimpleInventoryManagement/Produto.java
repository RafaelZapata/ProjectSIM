package SimpleInventoryManagement;

public class Produto implements iCadastrar{
	private String nome; 
	private String descricao;
	private double preco_de_custo;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco_de_custo() {
		return preco_de_custo;
	}

	public void setPreco_de_custo(double preco_de_custo) {
		this.preco_de_custo = preco_de_custo;
	}

	@Override
	public void novo_cadastro() {
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setPreco_de_custo(preco_de_custo);
		
	}	
}