package Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import SimpleInventoryManagement.Vendedor;

public class DMVendedor extends DMGeral{

	@Override
	public void incluir(Object obj) {
		Vendedor objVendedor = (Vendedor) obj;
		
		String incluirSqlVendedor = "INSERT INTO vendedor (nome, cpf, salario, id_venda) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlVendedor, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, objVendedor.getNome());
			pStmt.setString(2, objVendedor.getCpf());
			pStmt.setFloat(3, objVendedor.getSalario());
			pStmt.setInt(4, objVendedor.getAtRefVenda().getIdVenda());
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
				JOptionPane.showMessageDialog(null, "Vendedor já cadastrado");
				JOptionPane.showMessageDialog(null, "Código do vendedor: "+objVendedor.getIdVendedor());
				pStmt.close();
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

}
