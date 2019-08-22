package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import model.ListaProdutos;
import model.Produto;

public class DMListaProduto extends DMGeral{

	@Override
	public void incluir(Object obj) {
		ListaProdutos objListaProdutos = (ListaProdutos) obj;
		String incluirSqlListaProdutos = "INSERT INTO ListaProdutos (quantidade, FK_Venda_idVenda, FK_Produto_idProduto) VALUES (?, ?)";
		try {
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlListaProdutos);
			pStmt.setInt(1, objListaProdutos.getQuantidade());
			pStmt.setInt(2, objListaProdutos.getIdVenda());
			pStmt.setInt(3, objListaProdutos.getIdProduto());
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
			pStmt.setInt(1, objListaProdutos.getIdProduto());
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
	
	public List<Produto> listarProdutos(int id){
		
		List<Produto> produtos = new ArrayList<Produto>();
		Produto pro = new Produto();
		pro.conecta();
		try {
			String consultarSqlProduto = "SELECT * FROM Produto WHERE FK_Venda_idVenda = "+id+";";
			Statement stmt = getConnection().createStatement();
			ResultSet result = stmt.executeQuery(consultarSqlProduto);
			while(result.next()) {
				pro.setIdProduto(Integer.parseInt(result.getString("idProduto")));
				pro.setDescricao(result.getString("descricao"));
				pro.setQuantidade(Integer.parseInt(result.getString("quantidade")));
				pro.setValor(Float.parseFloat(result.getString("valor")));
				produtos.add(pro);
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
