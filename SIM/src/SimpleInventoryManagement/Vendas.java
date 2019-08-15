package SimpleInventoryManagement;

import java.util.Date;

import Util.*;

public class Vendas{
	private Date data;
	private float precoTotal;
	private int idVenda; //Armazena o código da venda do banco de dados
	private Vendedor atRefVendedor;
	private Cliente atRefCliente;
	private Produto atRefProduto;
	
	private DMVenda dmVenda;
	
	public Vendas(float precoTotal, Date data, Vendedor objVendedor, Cliente objCliente, Produto objProduto) {
		this.precoTotal = precoTotal;
		this.data = data;
		this.atRefVendedor = objVendedor;
		this.atRefCliente = objCliente;
		this.atRefProduto = objProduto;
		dmVenda = new DMVenda();
		dmVenda.conectaDatabase();
		incluir(this);
	}
	
	public Date getData() {
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

	public void setData(Date data) {
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
	
	public Object consultar() {
		return dmVenda.consultar(this);
	}
	
	public void incluir(Vendas objVenda) {
		dmVenda.incluir(this);
	}
	
}
