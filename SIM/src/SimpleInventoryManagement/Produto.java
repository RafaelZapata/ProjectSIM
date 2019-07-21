package SimpleInventoryManagement;

import javax.swing.JOptionPane;

import Util.*;

public class Produto {
	private int idProduto; //Armazena o id do produto do banco de dados
	private String nome; 
	private String descricao;
	private int quantidade;
	private float preco_de_custo;
	private float preco_de_venda;
	
	private DMProduto dmProduto;
	
	public Produto(String nome, String descricao, int quantidade, float preco_de_custo, float preco_de_venda){
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco_de_custo = preco_de_custo;
		this.preco_de_venda = preco_de_venda;
		dmProduto = new DMProduto();
		dmProduto.conectaDatabase();
		incluir(this);
	}
	
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco_de_custo() {
		return preco_de_custo;
	}

	public void setPreco_de_custo(float preco_de_custo) {
		this.preco_de_custo = preco_de_custo;
	}
	
	public void setPreco_de_venda(float preco_de_venda) {
		this.preco_de_venda = preco_de_venda;
	}
	
	public float getPreco_de_venda() {
		return preco_de_venda;
	}
	
	public Object consultar() {
		return dmProduto.consultar(this);
	}
	
	public void incluir(Produto objProduto) {
		if(objProduto.getNome().equals("")) {
			JOptionPane.showMessageDialog(null, "É necessário o nome do produto a ser cadastrado");
		} else {
			if(objProduto.getNome()!=null) {
				JOptionPane.showMessageDialog(null, "Já existe um produto com esse nome");
			} else {
				dmProduto.incluir(this);
			}
		}
	}
}