package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.*;

public class DMVenda extends DMGeral{

	@Override
	public void incluir(Object obj) {
		Vendas objVenda = (Vendas) obj;
		
		try {
			String incluirSqlVenda = "INSERT INTO Venda (vendaValor, dataVenda, FK_Cliente_idCliente, FK_Vendedor_idVendedor)"
					+ "VALUES (?, ?, ?, ?)";
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlVenda, Statement.RETURN_GENERATED_KEYS);
			pStmt.setFloat(1, objVenda.getValorVenda());
			pStmt.setString(2, objVenda.getData());
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
		Vendas objVenda = (Vendas) obj;
		String consultarProdutosVenda = "SELECT * FROM Venda, ListaProdutos WHERE idVenda = (?);";
		try {
			PreparedStatement pStmt = getConnection().prepareStatement(consultarProdutosVenda);
			pStmt.setInt(1, objVenda.getIdVenda());
			ResultSet result = pStmt.executeQuery();
			if(result.next()) {
				Vendedor vendedor = new Vendedor();
				Cliente cliente = new Cliente();
				vendedor.setIdVendedor(Integer.parseInt(result.getString("FK_Vendedor_idVendedor")));
				vendedor.setNome(result.getString("nome"));
				cliente.setIdCliente(Integer.parseInt(result.getString("FK_Cliente_idCliente")));
				cliente.setNome(result.getString("nome"));
				objVenda.setAtRefCliente(cliente);
				objVenda.setAtRefVendedor(vendedor);
				result.close();
			} else {
				System.out.println("Nada encontrado!");
				objVenda = null;
			}
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objVenda;
	}

}
