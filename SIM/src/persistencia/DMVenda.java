package persistencia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import model.*;

public class DMVenda extends DMGeral{

	@Override
	public void incluir(Object obj) {
		Vendas objVenda = (Vendas) obj;
		
		try {
			String incluirSqlVenda = "INSERT INTO Venda (vendaValor, dataVenda, FK_Cliente_idCliente, FK_Vendedor_idVendedor)"
					+ "VALUES (?, ?, ?, ?)";
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlVenda, Statement.RETURN_GENERATED_KEYS);
			pStmt.setFloat(1, objVenda.getprecoTotal());
			pStmt.setDate(2, (Date) objVenda.getData());
			pStmt.setInt(3, objVenda.getAtRefCliente().getIdCliente());
			pStmt.setInt(4, objVenda.getAtRefVendedor().getIdVendedor());
			pStmt.executeUpdate();
			
			ResultSet resultSet = pStmt.getGeneratedKeys();
			resultSet.next();
			int idGerado = resultSet.getInt(1);
			objVenda.setIdVenda(idGerado);
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
