package model;

import java.util.List;

import persistencia.*;

public class Vendas{
	private String data;
	private float vendaValor;
	private int idVenda; //Armazena o código da venda do banco de dados
	private Vendedor atRefVendedor;
	private Cliente atRefCliente;
	private ListaProdutos atRefListaProdutos;
	private List<Produto> objList;

	private Produto atRefProduto;
	
	private DMVenda dmVenda;
	
	public Vendas(float vendaValor, String data, Vendedor objVendedor, Cliente objCliente) {
		this.vendaValor  =vendaValor;
		this.data = data;
		this.atRefVendedor = objVendedor;
		this.atRefCliente = objCliente;
		dmVenda = new DMVenda();
		dmVenda.conectaDatabase();
		incluir(this);
	}
	
	public String getData() {
		return data;
	}

	public Vendedor getAtRefVendedor() {
		return atRefVendedor;
	}	
	public List<Produto> getList(){
		return objList = atRefListaProdutos.getListaProdutos();
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

	public void setData(String data) {
		this.data = data;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
public float getVendaValor() {
		return vendaValor;
	}

	public void setVendaValor(float vendaValor) {
		this.vendaValor = vendaValor;
	}

		public Object consultar() {
		return dmVenda.consultar(this);
	}
	
	public void incluir(Vendas objVenda) {
		dmVenda.incluir(this);
	}
	
}
