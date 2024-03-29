package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import persistencia.*;

public class Vendas{
	private String data;
	private float valorVenda;
	private int idVenda; //Armazena o c�digo da venda do banco de dados
	private int idVendedor;
	private int idCliente;
	private boolean status;
	private Cliente atRefCliente;
	private Vendedor atRefVendedor;
	private Vector<Integer> listaProdutosDisponiveis = new Vector<Integer>();
	private List<ListaProdutos> list = new ArrayList<ListaProdutos>();
	
	private DMVenda dmVenda;
	
	
	//M�todos construtores//
	
	
	public Vendas() {
		this.status = true;
		dmVenda = new DMVenda();
		dmVenda.conectaDatabase();
	}
	
	public Vendas(int idCliente, int idVendedor, String data) {
		this.idCliente = idCliente;
		this.idVendedor = idVendedor;
		this.data = data;
		this.status = true;
		dmVenda = new DMVenda();
		dmVenda.conectaDatabase();
		
	}
	
	public Vendas(float valorVenda, String data, int idVendedor, int idCliente) {
		this.valorVenda = valorVenda;
		this.data = data;
		this.idVendedor = idVendedor;
		this.idCliente = idCliente;
		this.status = true;
		dmVenda = new DMVenda();
		dmVenda.conectaDatabase();
		incluir();
	}
	
	//----------------------------------------------//
	
	
	//Set e Get//
	
	public Cliente getAtRefCliente() {
		return atRefCliente;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setAtRefCliente(Cliente atRefCliente) {
		this.atRefCliente = atRefCliente;
	}

	public Vendedor getAtRefVendedor() {
		return atRefVendedor;
	}

	public void setAtRefVendedor(Vendedor atRefVendedor) {
		this.atRefVendedor = atRefVendedor;
	}
	
	public List<ListaProdutos> getList() {
		return list;
	}
	
	public void setList(List<ListaProdutos> lp) {
		this.list = lp;
	}
	
	public String getData() {
		return data;
	}

	public int getIdVendedor() {
		if(this.atRefVendedor != null) {
			return atRefVendedor.getId();
		}
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public int getIdCliente() {
		if(this.atRefCliente != null) {
			return atRefCliente.getId();
		}
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void setData(String data) {
		this.data = data;
	}

	public float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda() {
		this.valorVenda = this.calcularTotal();
	}
	
	public void setValorVenda(float valor) {
		this.valorVenda = valor;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
	public void getListaProdutosDisponiveis() {
		listaProdutosDisponiveis = dmVenda.getListaProdutosDisponiveis();
	}
	//----------------------------------------------//

	
	
	//Fun��es//
	
	public boolean addProduto(int id, int quantidade) {
		ListaProdutos lp = new ListaProdutos(id, quantidade);
		if(listaProdutosDisponiveis.isEmpty()) {
			this.getListaProdutosDisponiveis();
		}
		if(listaProdutosDisponiveis.contains(id)) {
			Produto pro = new Produto(id);
			pro.consultar();
			if(pro.getQuantidade()> quantidade) {
				list.add(lp);	
			}else {
				JOptionPane.showMessageDialog(null, "Quantidade indipon�vel do produto.\nDispon�vel: "+pro.getQuantidade()+"\nSolicitado: "+quantidade);
				return false;
			}
			return true;
		}else JOptionPane.showMessageDialog(null, "Produto n�o encontrado!");
		return false;
	}
	
	public boolean excluirProduto(int id, int quantidade) {
		for(ListaProdutos l : list) {
			if(l.getIdProduto()==id) {
				int qtd = l.getQuantidade();
				l.setQuantidade(qtd-quantidade);
				JOptionPane.showMessageDialog(null, "Quantidade removida");
				if(l.getQuantidade()<=0 || quantidade == -1) {
					JOptionPane.showMessageDialog(null, "Produto removido do carrinho");
					list.remove(l);
					return true;
				}
			}
		}
		return false;
	}
	
	public Object consultar() {
		return dmVenda.consultar(this);
	}
	
	public void incluir() {
		this.setValorVenda();
		if(list == null) {
			JOptionPane.showMessageDialog(null, "Impossivel incluir venda!");
		} else {
			if(dmVenda.incluir(this)) {
				JOptionPane.showMessageDialog(null, "Venda cadastrada com Sucesso!");
			}else {
				JOptionPane.showMessageDialog(null, "Falha ao cadastrar venda!");
			}
		}
	}
	
	public void cancelarVenda() {
		if(dmVenda.cancelar(this.idVenda)) {
			JOptionPane.showMessageDialog(null, "Venda cancelada!");
		}else {
			JOptionPane.showMessageDialog(null, "Erro ao cancelar a venda!");
		}
	}
	
	public void imprimir() {
		JOptionPane.showMessageDialog(null, "Id da Venda: "+this.getIdVenda() + "\nVendedor: "+atRefVendedor.getNome()+ "\nCliente:" + atRefCliente.getNome()+"\nCPF: "+atRefCliente.getCpf()+"\nData: "+this.getData()+"\nValor: R$"+this.getValorVenda());
	}
	
	public float calcularTotal() {
		float total = 0;
		for (ListaProdutos lp2 : this.list) {
			try {
				String consultarSqlProduto = "SELECT * FROM Produto WHERE idProduto = (?);";
				PreparedStatement pStmt = dmVenda.getConnection().prepareStatement(consultarSqlProduto);
				pStmt.setInt(1, lp2.getIdProduto());
				ResultSet result = pStmt.executeQuery();
				while(result.next()) {
					total +=lp2.getQuantidade()*Float.parseFloat(result.getString("valor")); 
				}
				result.close();
				pStmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		return total;
	}
	
	//----------------------------------------------//
}