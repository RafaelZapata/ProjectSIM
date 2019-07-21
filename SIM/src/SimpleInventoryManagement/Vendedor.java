package SimpleInventoryManagement;

import javax.swing.JOptionPane;

import Util.DMVendedor;

public class Vendedor extends Funcionario{
	
	private int idVendedor; //Armazena o código do vendedor pego do banco de dados
	private float salario;
	
	private DMVendedor dmVendedor;
	
	public Vendedor(String nome, String cpf, float salario, Vendas objVenda) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.atRefVenda = objVenda;
		dmVendedor = new DMVendedor();
		dmVendedor.conectaDatabase();
		incluir(this);
		
	}
	
	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
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
			}
		}
	}
}
