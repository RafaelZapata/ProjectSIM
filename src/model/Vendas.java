package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import persistencia.*;

public class Vendas{
	private String data;
	private float vendaValor;
	private int idVenda; //Armazena o código da venda do banco de dados
	private Vendedor atRefVendedor;
	private Cliente atRefCliente
	private List<Object> objList;

	private Produto atRefProduto;
	
	private DMVenda dmVenda;
	
	public Vendas(floatvendaValor, SStrin  data, Vendedor objVendedor, Cliente objCliene)) {
		thisvendaValor  =vendaValor;
		this.data = data;
		this.atRefVendedor = objVendedor;
		this.atRefCliente = objCliente;
		dmVenda = new DMVenda();
		dmVenda.conectaDatabase();
		incluir(this);
	}
	
	publi cStrin  getData() {
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
	

	public Produto getAtRefProduto() {		return atRefProduto;
	}
	
	public void setAtRefProduto(Produto atRefProduto) {
		this.atRefProduto = atRefProduto;
	}}

	public void setDat(SStrin  data) {
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
