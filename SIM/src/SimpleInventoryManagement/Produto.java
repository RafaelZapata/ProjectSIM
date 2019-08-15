package SimpleInventoryManagement;

import java.util.*;

import javax.swing.JOptionPane;

import Util.*;

public class Produto {
	private int idProduto; //Armazena o id do produto do banco de dados 
	private String descricao;
	private int quantidade;
	private float valor;
	
	private DMProduto dmProduto;
	
	public Produto() {
		
	}
	
	public Produto(String descricao, float valor, int quantidade){
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
		dmProduto = new DMProduto();
		dmProduto.conectaDatabase();
		incluir(this);
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
	
	public List<Produto> pesquisar() {
		return dmProduto.pesquisar();
	}
	
	public void incluir(Produto objProduto) {
		if(objProduto.getDescricao().equals("")) {
			JOptionPane.showMessageDialog(null, "É necessário o nome do produto a ser cadastrado");
		} else {
			if(dmProduto.consultar(this)!=null) {
				JOptionPane.showMessageDialog(null, "Já existe um produto com esse nome");
			} else {
				dmProduto.incluir(this);
			}
		}
	}
}