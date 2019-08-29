package model;

import javax.swing.JOptionPane;

import persistencia.DMClienteEndereco;

public class ClienteEndereco {
	private Cliente atRefCliente;
	private Endereco atRefEndereco;
	private DMClienteEndereco dmClienteEndereco;
	
	public ClienteEndereco(Cliente objCliente, Endereco objEndereco) {
		this.atRefCliente = objCliente;
		this.atRefEndereco = objEndereco;
		dmClienteEndereco = new DMClienteEndereco();
		dmClienteEndereco.conectaDatabase();
		incluir(this);
	}

	public Cliente getAtRefCliente() {
		return atRefCliente;
	}

	public void setAtRefCliente(Cliente atRefCliente) {
		this.atRefCliente = atRefCliente;
	}

	public Endereco getAtRefEndereco() {
		return atRefEndereco;
	}

	public void setAtRefEndereco(Endereco atRefEndereco) {
		this.atRefEndereco = atRefEndereco;
	}
	
	public int consultar(int idCliente) {
		return dmClienteEndereco.pesquisar(idCliente);
	}
	
	public void incluir(ClienteEndereco objClienteEndereco) {
		dmClienteEndereco.incluir(this);
	}
	
	public void excluir() {
		if(!dmClienteEndereco.excluir(atRefCliente.getIdCliente())){
			JOptionPane.showMessageDialog(null, "Erro ao deletar");
		}
	}
	
}
