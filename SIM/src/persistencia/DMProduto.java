package persistencia;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import model.*;

public class DMProduto extends DMGeral {

	@Override
	public void incluir(Object obj) {
		Produto objProduto = (Produto) obj;
		try {
			String incluirSqlProduto = "INSERT INTO Produto (descricao, valor, quantidade) VALUES (?, ?, ?)";
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlProduto, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, objProduto.getDescricao());
			pStmt.setFloat(2, objProduto.getValor());
			pStmt.setInt(3, objProduto.getQuantidade());
			
			pStmt.executeUpdate();
			
			ResultSet resultSet = pStmt.getGeneratedKeys();
			resultSet.next();
			int idGerado = resultSet.getInt(1);
			objProduto.setIdProduto(idGerado);
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Object consultar(Object obj) {
		Produto objProduto = (Produto) obj;
		
		try {
			String consultarSqlProduto = "SELECT * FROM Produto where (descricao = (?))";
			PreparedStatement pStmt = getConnection().prepareStatement(consultarSqlProduto);
			pStmt.setString(1, objProduto.getDescricao());
			ResultSet result = pStmt.executeQuery();
			if(result.next()) {
				result.close();
			} else {
				objProduto = null;
			}
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objProduto;
	}
	
	public List<Produto> pesquisar(){
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		try {
			String consultarSqlProduto = "SELECT * FROM Produto;";
			PreparedStatement pStmt = getConnection().prepareStatement(consultarSqlProduto);
//			pStmt.setString(1, "%"+descricao+"%");
			ResultSet result = pStmt.executeQuery();
			while(result.next()) {
				Produto pro = new Produto(result.getString("descricao"), result.getFloat("valor"), result.getInt("quantidade"));
				pro.setIdProduto(result.getInt(1));
				produtos.add(pro);
			}
		
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produtos;
	}
	
	public void excluir(int id) {
		try {
			Statement stmt = getConnection().createStatement();
			String sqlExcluir = "DELETE FROM Produto WHERE idProduto = "+id+";";
			stmt.execute(sqlExcluir);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar");
			e.printStackTrace();
		}
	}
	
}
