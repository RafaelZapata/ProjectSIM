package SimpleInventoryManagement;

import Util.DMEndereco;

public class Endereco {
	private String rua, bairro, estado, cidade;
	private int numeroResidencia;
	private DMEndereco dmEndereco;
	private int idEndereco; //Armazena o id do banco de dados
	
	public Endereco(String rua, int numeroResidencia, String bairro, String cidade, String estado) {
		this.rua = rua;
		this.numeroResidencia = numeroResidencia;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		dmEndereco = new DMEndereco();
		dmEndereco.conectaDatabase();
		incluir(this);
		
	}
	
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String Estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getNumeroResidencia() {
		return numeroResidencia;
	}

	public void setNumeroResidencia(int numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public void incluir(Endereco objEndereco) {
		dmEndereco.incluir(this);
	}	
}
