package model;

import javax.swing.JOptionPane;

import persistencia.*;

public class Produto {
	private int idProduto; //Armazena o id do produto do banco de dados 
	private String descricao;
	private int quantidade;
	private float valor;
	
	private DMProduto dmProduto;
	
	public Produto() {}
	
	public Produto(int idProduto) {
		this.idProduto = idProduto;
		dmProduto = new DMProduto();
		dmProduto.conectaDatabase();
	}
	
	
	public Produto(String descricao) {
		this.descricao = descricao;
		dmProduto = new DMProduto();
		dmProduto.conectaDatabase();
	}
	
	public Produto(String descricao, float valor, int quantidade){
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
		dmProduto = new DMProduto();
		dmProduto.conectaDatabase();
		dmProduto.incluir(this);
	}
	
	public void conecta() {
		dmProduto = new DMProduto();
		dmProduto.conectaDatabase();
	}
	
	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Object consultar() {
		return dmProduto.consultar(this);
	}
	
	public void listarProdutos() {
		dmProduto.listarProdutos();
	}
	
	public void incluir() {
		dmProduto.conectaDatabase();
		if(this.getDescricao().equals("")) {
			JOptionPane.showMessageDialog(null, "É necessário o nome do produto a ser cadastrado!");
		} else {
			if(dmProduto.consultar(this)!=null) {
				JOptionPane.showMessageDialog(null, "Já existe um produto com esse nome!");
			} else {
				dmProduto.incluir(this);				
			}
		}
	}
	
	public void excluir() {
		dmProduto.excluir(this.idProduto);
	}
	
	public void imprimir() {
		JOptionPane.showMessageDialog(null, "ID: "+this.getIdProduto()+"\nDescrição: "+this.getDescricao() + "\nQuantidade: "+this.getQuantidade()+ "\nValor: R$" + this.getValor());
	}
	
	public String toString() {
		String retorno = "ID: "+this.getIdProduto()+"<br>Descrição: "+this.getDescricao() + "<br>Quantidade: "+this.getQuantidade()+ "<br>Valor: R$" + this.getValor()+"<br>";
		return retorno;
	}
	 
}