package model;

import java.util.List;


import persistencia.*;

public class ListaProdutos {
	private int idVenda;
	private int idProduto;
	private int quantidade;
	private DMListaProduto dmListaProduto;
	
	//Métodos construtores//
	
	public ListaProdutos() {
		dmListaProduto = new DMListaProduto();
		dmListaProduto.conectaDatabase();
	}
	
	public ListaProdutos(int idVenda) {
		this.idVenda = idVenda;
		dmListaProduto = new DMListaProduto();
		dmListaProduto.conectaDatabase();
	}
	
	public ListaProdutos(int idVenda, int idProduto, int quantidade) {
		this.idVenda = idVenda;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		dmListaProduto = new DMListaProduto();
		dmListaProduto.conectaDatabase();
		this.incluir();
	}
	
	public ListaProdutos(int idProduto, int quantidade) {
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		dmListaProduto = new DMListaProduto();
		dmListaProduto.conectaDatabase();
	}

	//----------------------------------------------//
	
	
	//Set e Get//
	
	public List<ListaProdutos> getListaProdutos(){
		return dmListaProduto.listarProdutos(this.idVenda);
	}
		
	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	//----------------------------------------------//
	
	//Funções//
	
	public Object consultar() {
		return dmListaProduto.consultar(this);
	}
	
	public void incluir() {
		dmListaProduto.incluir(this);
		
	}
	
	//----------------------------------------------//
}