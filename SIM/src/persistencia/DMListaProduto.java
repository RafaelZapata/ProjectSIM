package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ListaProdutos;

public class DMListaProduto extends DMGeral{

	@Override
	public void incluir(Object obj) {
		ListaProdutos objListaProdutos = (ListaProdutos) obj;
		String incluirSqlListaProdutos = "INSERT INTO ListaProdutos (quantidade, FK_Venda_idVenda, FK_Produto_idProduto) VALUES (?, ?)";
		try {
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlListaProdutos);
			pStmt.setInt(1, objListaProdutos.getQuantidade());
			pStmt.setInt(2, objListaProdutos.getAtRefVenda().getIdVenda());
			pStmt.setInt(3, objListaProdutos.getAtRefProduto().getIdProduto());
			pStmt.executeUpdate();
			
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	@Override
	public Object consultar(Object obj) {
		ListaProdutos objListaProdutos = (ListaProdutos) obj;
		
		try {
			String consultarSqlListaProdutos = "SELECT * FROM ListaProdutos where FK_Produto_idProduto = (?)";
			PreparedStatement pStmt = getConnection().prepareStatement(consultarSqlListaProdutos);
			pStmt.setInt(1, objListaProdutos.getAtRefProduto().getIdProduto());
			ResultSet result = pStmt.executeQuery();
			if(result.next()) {
				result.close();
			} else {
				objListaProdutos = null;
			}
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objListaProdutos;
	}
	
}
