package model;

import javax.swing.JOptionPane;

import persistencia.*;

public class ListaProdutos {
	private Vendas atRefVenda;
	private Produto atRefProduto;
	private int quantidade;
	private DMListaProduto dmListaProduto;
	
	public ListaProdutos(Vendas objVenda, Produto objProduto, int quantidade) {
		this.atRefVenda = objVenda;
		this.atRefProduto = objProduto;
		this.quantidade = quantidade;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Vendas getAtRefVenda() {
		return atRefVenda;
	}

	public void setAtRefVenda(Vendas atRefVenda) {
		this.atRefVenda = atRefVenda;
	}

	public Produto getAtRefProduto() {
		return atRefProduto;
	}

	public void setAtRefProduto(Produto atRefProduto) {
		this.atRefProduto = atRefProduto;
	}
	
	public Object consultar() {
		return dmListaProduto.consultar(this);
	}
	
	public void incluir() {
		dmListaProduto = new DMListaProduto();
		dmListaProduto.conectaDatabase();
		dmListaProduto.incluir(this);
	}
	
	public void excluir() {
		
	}
}
