package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.*;

public class DMClienteEndereco extends DMGeral{

	@Override
	public void incluir(Object obj) {
		ClienteEndereco objClienteEndereco = (ClienteEndereco) obj;
		String incluirSqlClienteEndereco = "INSERT INTO ClienteEndereco (FK_Cliente_idCliente, FK_Endereco_idEndereco) VALUES (?, ?)";
		try {
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlClienteEndereco);
			pStmt.setInt(1, objClienteEndereco.getAtRefCliente().getIdCliente());
			pStmt.setInt(2, objClienteEndereco.getAtRefEndereco().getIdEndereco());
			pStmt.executeUpdate();
			
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public Object consultar(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
