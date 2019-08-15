package SimpleInventoryManagement;

import java.util.Date;

import javax.swing.JOptionPane;

import Util.DMCliente;

public class Cliente{
	
	private int idCliente;

	private String nome;
	private String cpf;
	private Date dataNascimento;
//	private String endereco;
	private String telefone;
	private Endereco atRefEndereco;
	private DMCliente dmCliente;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String cpf, String telefone, Date dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		dmCliente = new DMCliente();
		dmCliente.conectaDatabase();
		incluir(this);
		
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Object consultar() {
		return dmCliente.consultar(this);
	}
	
	public void incluir(Cliente objCliente) {
		if(objCliente.cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "O cpf do cliente é obrigatorio");
		} else {
			if(dmCliente.consultar(this)!=null) {
				JOptionPane.showMessageDialog(null, "Já existe um cliente com esse cpf cadastrado");
			} else {
				dmCliente.incluir(this);
			}
		}
	}
	
//	public void shutdown() {
//		dmCliente.shutdown();
//	}
}