package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import model.*;

public class DMVenda extends DMGeral{

	@Override
	public void incluir(Object obj) {
		Vendas objVenda = (Vendas) obj;
		
		try {
			String incluirSqlVenda = "INSERT INTO Venda (vendaValor, dataVenda, status, FK_Cliente_idCliente, FK_Vendedor_idVendedor)"
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlVenda, Statement.RETURN_GENERATED_KEYS);
			pStmt.setFloat(1, objVenda.getValorVenda());
			pStmt.setString(2, objVenda.getData());
			pStmt.setBoolean(3, objVenda.isStatus());
			pStmt.setInt(4, objVenda.getIdCliente());
			pStmt.setInt(5, objVenda.getIdVendedor());
			pStmt.executeUpdate();
			
			ResultSet resultSet = pStmt.getGeneratedKeys();
			resultSet.next();
			int idGerado = resultSet.getInt(1);
			objVenda.setIdVenda(idGerado);			
		
			ListaProdutos lp = new ListaProdutos();
			for(ListaProdutos pro : objVenda.getList()) {
				System.out.println("Entrada de lista Produtos");
				lp.setIdProduto(pro.getIdProduto());
				lp.setIdVenda(objVenda.getIdVenda());
				lp.setQuantidade(pro.getQuantidade());
				lp.incluir();
				
			}
			
			JOptionPane.showMessageDialog(null, "Venda cadastrada com Sucesso!");
			
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Object consultar(Object obj) {
		Vendas objVenda = (Vendas) obj;
		String consultarProdutosVenda = "SELECT * FROM Venda WHERE idVenda = (?);";
		try {
			PreparedStatement pStmt = getConnection().prepareStatement(consultarProdutosVenda);
			pStmt.setInt(1, objVenda.getIdVenda());
			ResultSet result = pStmt.executeQuery();
			if(result.next()) {
				Vendedor vendedor = new Vendedor(result.getInt("FK_Vendedor_idVendedor"));
				vendedor.consultar();
				Cliente cliente = new Cliente(result.getInt("FK_Cliente_idCliente"));
				cliente.consultar();
				objVenda.setAtRefCliente(cliente);
				objVenda.setAtRefVendedor(vendedor);
				ListaProdutos lp = new ListaProdutos(objVenda.getIdVenda());
				objVenda.setList(lp.getListaProdutos());
				objVenda.setValorVenda(Float.parseFloat(result.getString("vendaValor")));
				objVenda.setStatus(result.getBoolean("status"));
				objVenda.setData(result.getString("dataVenda"));
				
				result.close();
			} else {
				objVenda = null;
			}
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objVenda;
	}
	
	public void cancelar(int id) {
		String sqlCancelar = "UPDATE Venda SET status = false WHERE idVenda = "+id+";";
		try {
			Statement stmt = getConnection().createStatement();
			if(stmt.executeUpdate(sqlCancelar) == 1) {
				JOptionPane.showMessageDialog(null, "Venda cancelada!");				
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao cancelar a venda!");				
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cancelar no banco de dados!");
			e.printStackTrace();
		}
	}
	
	public Vector<Integer> getListaProdutosDisponiveis() {
		Vector<Integer> lista = new Vector<Integer>();
		try {
			System.out.println("Buscando lista de produtos disponíveis...");
			String consultarSqlLista = "SELECT * FROM Produto";
			Statement stmt = getConnection().createStatement();
			ResultSet result = stmt.executeQuery(consultarSqlLista);
			while(result.next()) {
				lista.add(result.getInt("idProduto"));
			}
			result.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}
