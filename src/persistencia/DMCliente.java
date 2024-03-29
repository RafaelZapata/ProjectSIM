package persistencia;

import java.sql.*;
import model.*;

public class DMCliente extends DMGeral{
	Connection conCliente;

	@Override
	public boolean incluir(Object obj) {
		Cliente objCliente = (Cliente) obj;
		try {
//			Statement statement = getConnection().createStatement();
			String incluirSqlCliente = "INSERT INTO Cliente (nome, cpf, telefone, dataNascimento) VALUES (?, ?, ?, ?)";
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlCliente, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, objCliente.getNome());
			pStmt.setString(2, objCliente.getCpf());
			pStmt.setString(3, objCliente.getTelefone());
			pStmt.setString(4, objCliente.getDataNascimento());
			pStmt.executeUpdate();
			
			ResultSet resultSet = pStmt.getGeneratedKeys();
			resultSet.next();
			int idGerado = resultSet.getInt(1);
			objCliente.setIdCliente(idGerado);
			pStmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Object consultar(Object obj) {
		Cliente objCliente = (Cliente) obj;		
		String consultarSqlCliente;
		PreparedStatement pStmt;
		try {
			if(objCliente.getIdCliente() > 0) {
				consultarSqlCliente = "SELECT * FROM Cliente, ClienteEndereco, Endereco WHERE (Cliente.idCliente = ClienteEndereco.FK_Cliente_idCliente) and (ClienteEndereco.FK_Endereco_idEndereco = Endereco.idEndereco) and (Cliente.idCliente = (?))";
				pStmt  = getConnection().prepareStatement(consultarSqlCliente);
				pStmt.setInt(1, objCliente.getIdCliente());
			}else if ((objCliente.getNome() != null) && (!objCliente.getNome().trim().equals(""))){
				consultarSqlCliente = "SELECT * FROM Cliente, ClienteEndereco, Endereco WHERE (Cliente.idCliente = ClienteEndereco.FK_Cliente_idCliente) and (ClienteEndereco.FK_Endereco_idEndereco = Endereco.idEndereco) and (Cliente.nome LIKE (?))";
				pStmt  = getConnection().prepareStatement(consultarSqlCliente);
				pStmt.setString(1, "%"+objCliente.getNome()+"%");
			}else {
				consultarSqlCliente = "SELECT * FROM Cliente, ClienteEndereco, Endereco WHERE (Cliente.idCliente = ClienteEndereco.FK_Cliente_idCliente) and (ClienteEndereco.FK_Endereco_idEndereco = Endereco.idEndereco) and (Cliente.cpf = (?))";
				pStmt  = getConnection().prepareStatement(consultarSqlCliente);
				pStmt.setString(1, objCliente.getCpf());
			}
			ResultSet result = pStmt.executeQuery();
			if(result.next()) {
				Endereco end = new Endereco();
				end.setBairro(result.getString("bairro"));
				end.setCidade(result.getString("cidade"));
				end.setEstado(result.getString("estado"));
				end.setNumeroResidencia(Integer.parseInt(result.getString("numero")));
				end.setRua(result.getString("rua"));
				objCliente.setAtRefEndereco(end);
				objCliente.setCpf(result.getString("cpf"));
				objCliente.setNome(result.getString("nome"));
				objCliente.setTelefone(result.getString("telefone"));
				objCliente.setDataNascimento(result.getString("dataNascimento"));
				objCliente.setIdCliente(Integer.parseInt(result.getString("idCliente")));
				result.close();
			} else {
				System.out.println("Nada encontrado!");
				objCliente = null;
			}
			pStmt.close();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return objCliente;
	}
	
	public boolean excluir(int id) {
		try {
			Statement stmt = getConnection().createStatement();
			String sqlExcluir = "DELETE FROM Cliente WHERE idCliente = "+id+";";
			stmt.execute(sqlExcluir);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
