package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ListaProdutos;

public class DMListaProduto extends DMGeral{

	@Override
	public boolean incluir(Object obj) {
		ListaProdutos objListaProdutos = (ListaProdutos) obj;
		String incluirSqlListaProdutos = "INSERT INTO ListaProdutos (quantidade, FK_Venda_idVenda, FK_Produto_idProduto) VALUES (?, ?, ?)";
		try {
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlListaProdutos);
			pStmt.setInt(1, objListaProdutos.getQuantidade());
			pStmt.setInt(2, objListaProdutos.getIdVenda());
			pStmt.setInt(3, objListaProdutos.getIdProduto());
			pStmt.executeUpdate();
			
			pStmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Falha DMListaProdutos!");
			e.printStackTrace();
			return false;
		}		
		
	}

	@Override
	public Object consultar(Object obj) {
		ListaProdutos objListaProdutos = (ListaProdutos) obj;
		
		try {
			String consultarSqlListaProdutos = "SELECT * FROM ListaProdutos where FK_Produto_idProduto = (?)";
			PreparedStatement pStmt = getConnection().prepareStatement(consultarSqlListaProdutos);
			pStmt.setInt(1, objListaProdutos.getIdProduto());
			ResultSet result = pStmt.executeQuery();
			if(result.next()) {
				//
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
	
	public List<ListaProdutos> listarProdutos(int id){
		
		List<ListaProdutos> produtos =  new ArrayList<ListaProdutos>();
		try {
			String consultarSqlLista = "SELECT * FROM ListaProdutos WHERE FK_Venda_idVenda = "+id+";";
			Statement stmt = getConnection().createStatement();
			ResultSet result = stmt.executeQuery(consultarSqlLista);
			while(result.next()) {
				ListaProdutos lp = new ListaProdutos(result.getInt("FK_Venda_idVenda"),result.getInt("FK_Produto_idProduto"), result.getInt("quantidade"));
				produtos.add(lp);
			}
			
			result.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produtos;
	}
}
