package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import persistencia.*;

public class ListaProdutos {
	private int idVenda;
	private int idProduto;
	private int quantidade;
	private DMListaProduto dmListaProduto;
	
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
		dmListaProduto.incluir(this);
	}

	public List<Produto> getListaProdutos(){
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
	
	public Object consultar() {
		return dmListaProduto.consultar(this);
	}
	
	public void incluir() {
		dmListaProduto = new DMListaProduto();
		
	}
	
	public void excluir() {
		
	}
}
