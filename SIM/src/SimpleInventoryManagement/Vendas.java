package SimpleInventoryManagement;

public class Vendas{
	public Produto[] produto;
	public String data;
	public double preco;
	
	public Vendas(Produto[] produto, String data) {
		this.setProduto(produto);
		this.setData(data);
		this.calcularValor();
	}
	
	public Produto[] getProduto() {
		return produto;
	}

	public void setProduto(Produto[] produto) {
		this.produto = produto;
	}

	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

	public double calcularValor() {
		double valorTotal = 0;
		for(int i=0; i<produto.length; i++) {
			
		}	
		return valorTotal;
	}
	
	public double desconto() {
		return this.calcularValor() - (0.05*this.calcularValor());
	}
	
//	Relatorio do vendedor e da venda
	public String gerarVendas(Vendedor vendedor) {
		return ("Vendedor: "+vendedor.getNome()+"\nCodigo vendedor: "+vendedor.getCodigoVendedor()+
				"\nValor total: R$"+this.calcularValor()+"\nÀ vista no dinheiro: R$"+desconto()+"\nData da venda: "+this.getData());
	}
	
}
