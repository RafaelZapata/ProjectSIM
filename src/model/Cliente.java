package model;

import javax.swing.JOptionPane;

import persistencia.DMCliente;

public class Cliente extends Pessoa{
	
	private Endereco atRefEndereco;
	private DMCliente dmCliente;
	private String dataNascimento;
	private String telefone;
	
	public Cliente() {
		dmCliente = new DMCliente();
		dmCliente.conectaDatabase();
	}
	
	public Cliente(String cpf) {
		this.setCpf(cpf);
		dmCliente = new DMCliente();
		dmCliente.conectaDatabase();
	}
	
	public Cliente(String nome, String cpf, String telefone, String dataNascimento, Endereco objEndereco) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.atRefEndereco = objEndereco;
		dmCliente = new DMCliente();
		dmCliente.conectaDatabase();
		incluir(this);
		
	}
	
	public int getIdCliente() {
		return this.getId();
	}

	public void setIdCliente(int idCliente) {
		this.setId(idCliente);
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
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Endereco getAtRefEndereco() {
		return atRefEndereco;
	}

	public void setAtRefEndereco(Endereco atRefEndereco) {
		this.atRefEndereco = atRefEndereco;
	}

	public Object consultar() {
		return dmCliente.consultar(this);
	}
	
	public void incluir(Cliente objCliente) {
		if(objCliente.cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "CPF Obrigatório!");
		} else {
			if(dmCliente.consultar(this)!=null) {
				JOptionPane.showMessageDialog(null, "Já existe um cliente com esse cpf cadastrado");
			} else {
				dmCliente.incluir(this);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");
			}
		}
	}
	
	public void excluir() {
		dmCliente.excluir(this.id);
	}
	
	public void imprimir() {
		JOptionPane.showMessageDialog(null, "Nome: "+this.getNome() + "\nCpf: "+this.getCpf()+ "\nData Nascimento:" + this.getDataNascimento()+ "\nTelefone: " + this.getTelefone()+"\nRua: "+this.getAtRefEndereco().getRua() + "\nNumero: "+this.getAtRefEndereco().getNumeroResidencia()+ "\nBairro:" + this.getAtRefEndereco().getBairro()+ "\nCidade: " + this.getAtRefEndereco().getCidade() + "\nEstado: " + this.getAtRefEndereco().getEstado());
	}
	 
//	public void shutdown() {
//		dmCliente.shutdown();
//	}
}