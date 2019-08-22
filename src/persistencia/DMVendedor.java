package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Vendedor;

public class DMVendedor extends DMGeral{

	@Override
	public void incluir(Object obj) {
		Vendedor objVendedor = (Vendedor) obj;
		
		String incluirSqlVendedor = "INSERT INTO vendedor (cpf, nome, dataAdmissao, salario) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlVendedor, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, objVendedor.getCpf());
			pStmt.setString(2, objVendedor.getNome());
			pStmt.setString(3, objVendedor.getDataAdmissao());
			pStmt.setFloat(4, objVendedor.getSalario());
			pStmt.executeUpdate();
			
			ResultSet resultSet = pStmt.getGeneratedKeys();
			resultSet.next();
			int idGerado = resultSet.getInt(1);
			objVendedor.setIdVendedor(idGerado);
			
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Object consultar(Object obj) {
		Vendedor objVendedor = (Vendedor) obj;
		
		String consultarSqlVendedor = "SELECT * FROM vendedor WHERE (cpf = (?))";
		try {
			PreparedStatement pStmt = getConnection().prepareStatement(consultarSqlVendedor);
			pStmt.setString(1, objVendedor.getCpf());
			ResultSet result = pStmt.executeQuery();
			if(result.next()) {
				objVendedor.setId( Integer.parseInt(result.getString("idVendedor")));
				objVendedor.setCpf(result.getString("cpf"));
				objVendedor.setDataAdmissao(result.getString("dataAdmissao"));
				objVendedor.setNome(result.getString("nome"));
				objVendedor.setSalario(Float.parseFloat(result.getString("salario")));
				result.close();
			} else {
				objVendedor = null;
			}
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objVendedor;
	}
	
	public void excluir(int id) {
		try {
			Statement stmt = getConnection().createStatement();
			String sqlExcluir = "DELETE FROM Vendedor WHERE idVendedor = "+id+";";
			stmt.execute(sqlExcluir);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar");
			e.printStackTrace();
		}
	}

}
