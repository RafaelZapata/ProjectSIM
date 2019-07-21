package SimpleInventoryManagement;

public class Vendas{
	private String data;
	private float precoTotal;
	private int idVenda; //Armazena o código da venda do banco de dados
	private Vendedor atRefVendedor;
	private Cliente atRefCliente;
	private Produto atRefProduto;
	
	public Vendas() {
		
	}
	
	public String getData() {
		return data;
	}

	public Vendedor getAtRefVendedor() {
		return atRefVendedor;
	}

	public void setAtRefVendedor(Vendedor atRefVendedor) {
		this.atRefVendedor = atRefVendedor;
	}

	public Cliente getAtRefCliente() {
		return atRefCliente;
	}

	public void setAtRefCliente(Cliente atRefCliente) {
		this.atRefCliente = atRefCliente;
	}

	public Produto getAtRefProduto() {
		return atRefProduto;
	}

	public void setAtRefProduto(Produto atRefProduto) {
		this.atRefProduto = atRefProduto;
	}

	public void setData(String data) {
		this.data = data;
	}

	public float getprecoTotal() {
		return precoTotal;
	}

	public void setprecoTotal(float precoTotal) {
		this.precoTotal = precoTotal;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
}
