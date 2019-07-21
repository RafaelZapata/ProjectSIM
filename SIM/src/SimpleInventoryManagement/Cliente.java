package SimpleInventoryManagement;

import javax.swing.JOptionPane;

import Util.DMCliente;

public class Cliente{
	
	private int idCliente;

	private String nome;
	private String cpf;
	private String dataNascimento;
//	private String endereco;
	private String telefone;
	private Endereco atRefEndereco;
	private DMCliente dmCliente;
	
	public Cliente(String nome, String cpf, String dataNascimento, String telefone, Endereco objEndereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.atRefEndereco = objEndereco;
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
	
//	public String getEndereco() {
//		return endereco;
//	}
//	public void setEndereco(String endereco) {
//		this.endereco = endereco;
//	}
	
	
	public String getTelefone() {
		return telefone;
	}
	public Endereco getAtRefEndereco() {
		return atRefEndereco;
	}


	public void setAtRefEndereco(Endereco atRefEndereco) {
		this.atRefEndereco = atRefEndereco;
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
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

//	public Object buscar(String cpf) {
//		Cliente objCliente = (Cliente) dmCliente.buscar(cpf);
//		if(objCliente != null) {
//			return objCliente;
//		}
//		return objCliente;
//	}
	
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