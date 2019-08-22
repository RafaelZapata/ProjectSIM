package persistencia;

import java.sql.*;

import javax.swing.JOptionPane;

import apresentacao.RelatorioProdutos;
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
				objProduto.setIdProduto(Integer.parseInt(result.getString("idProduto")));
				objProduto.setDescricao(result.getString("descricao"));
				objProduto.setQuantidade(Integer.parseInt(result.getString("quantidade")));
				objProduto.setValor(Float.parseFloat(result.getString("valor")));
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
	
	public void listarProdutos() {
		String relatorio = "Relatório Geral dos Produtos: \n";
		Produto pro;
		this.conectaDatabase();
		try {
			String sqlListar = "SELECT * FROM Produto ORDER BY descricao ASC;";
			Statement stmt = getConnection().createStatement();
			ResultSet result = stmt.executeQuery(sqlListar);
			while(result.next()) {
				pro = new Produto();
				pro.setIdProduto(Integer.parseInt(result.getString("idProduto")));
				pro.setDescricao(result.getString("descricao"));
				pro.setQuantidade(Integer.parseInt(result.getString("quantidade")));
				pro.setValor(Float.parseFloat(result.getString("valor")));
				relatorio += pro.toString();
				pro = null;
			}
			result.close();
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao exibir lista de produtos");
			e.printStackTrace();
		}
		
		RelatorioProdutos rp = new RelatorioProdutos(relatorio);
		this.shutDown();
	}
	
}
