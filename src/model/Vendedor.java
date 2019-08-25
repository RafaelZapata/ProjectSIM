package model;

import javax.swing.JOptionPane;

import persistencia.DMVendedor;

public class Vendedor extends Funcionario{
	
	private DMVendedor dmVendedor;
	
	public Vendedor() {
		dmVendedor = new DMVendedor();
		dmVendedor.conectaDatabase();
	}
	
	public Vendedor(String cpf) {
		this.cpf = cpf;
		dmVendedor = new DMVendedor();
		dmVendedor.conectaDatabase();
		
	}
	
	public Vendedor(String nome, String cpf, float salario, String dataAdmissao) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
		dmVendedor = new DMVendedor();
		dmVendedor.conectaDatabase();
		incluir(this);
		
	}
	
	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public int getIdVendedor() {
		return this.id;
	}

	public void setIdVendedor(int idVendedor) {
		this.id = idVendedor;
	}
	
	public float getSalario() {
		return salario;
	}
	
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public Object consultar() {
		return dmVendedor.consultar(this);
	}
	
	public void incluir(Vendedor objVendedor) {
		if(objVendedor.getCpf().equals("")) {
			JOptionPane.showMessageDialog(null, "O cpf do vendedor é obrigatorio");
		} else {
			if(dmVendedor.consultar(objVendedor)!=null) {
				JOptionPane.showMessageDialog(null, "Já existe um vendedor cadastrado nesse cpf");
			} else {
				dmVendedor.incluir(objVendedor);
				JOptionPane.showMessageDialog(null, "Cadastrado com suceso!!");
			}
		}
	}
	
	public void excluir() {
		dmVendedor.excluir(this.id);
	}
	
	public void imprimir() {
		JOptionPane.showMessageDialog(null, "Nome: "+this.getNome() + "\nCpf: "+this.getCpf()+ "\nData de Admiss�o:" + this.getDataAdmissao()+ "\nSalario: " + this.getSalario());
	}
}
