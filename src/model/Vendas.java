package model;

import java.util.Date;
import java.util.List;

import persistencia.*;

public class Vendas{
	private String data;
	private float valorVenda;
	private int idVenda; //Armazena o código da venda do banco de dados
	private Vendedor atRefVendedor;
	private Cliente atRefCliente;
	private ListaProdutos atRefListaProdutos;
	private List<Produto> list;
	
	private DMVenda dmVenda;
	
	public Vendas(float valorVenda, String data, Vendedor objVendedor, Cliente objCliente) {
		this.valorVenda = valorVenda;
		this.data = data;
		this.atRefVendedor = objVendedor;
		this.atRefCliente = objCliente;
		list = atRefListaProdutos.getListaProdutos();
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

	public float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
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

