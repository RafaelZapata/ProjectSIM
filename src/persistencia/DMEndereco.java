package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Endereco;

public class DMEndereco extends DMGeral{

	@Override
	public void incluir(Object obj) {
		Endereco objEndereco= (Endereco) obj;
		try {
			String incluirSqlEndereco= "INSERT INTO Endereco(rua, numero, bairro, cidade, estado) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlEndereco, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, objEndereco.getRua());
			pStmt.setInt(2, objEndereco.getNumeroResidencia());
			pStmt.setString(3, objEndereco.getBairro());
			pStmt.setString(4, objEndereco.getCidade());
			pStmt.setString(5, objEndereco.getEstado());
			pStmt.executeUpdate();
			
			ResultSet resultSet = pStmt.getGeneratedKeys();
			resultSet.next();
			int idGerado = resultSet.getInt(1);
			objEndereco.setIdEndereco(idGerado);
			
			pStmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public Object consultar(Object obj) {
		Endereco objEndereco = (Endereco) obj;
		
		try {
			String consultarSqlProduto = "SELECT * FROM Endereco where (nome = (?)) AND (numeroResidencia = (?))";
			PreparedStatement pStmt = getConnection().prepareStatement(consultarSqlProduto);
			pStmt.setString(1, objEndereco.getRua());
			pStmt.setInt(2, objEndereco.getNumeroResidencia());
			ResultSet result = pStmt.executeQuery();
			if(result.next()) {
				//Pegar o id do endereço e relacionar com o id do cliente
				//Não codificado ainda 
				result.close();
			} else {
				objEndereco = null;
			}
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objEndereco;
	}
	
	public Endereco pesquisar(int idEndereco) {
		Endereco end = new Endereco();
    	try{   
    		Statement statement = getConnection().createStatement();
            
    		//montagem da String SQL de consulta na tabela        	
    		String consultarSqlEndereco = "SELECT * from Endereco idEndereco = ("+idEndereco+")";
            System.out.println("Enviando c�digo SQL: " + getConnection().nativeSQL(consultarSqlEndereco));
            ResultSet result = statement.executeQuery(consultarSqlEndereco);
            if (result.next()){   
                end.setBairro(result.getString("bairro"));
                end.setCidade(result.getString("cidade"));
                end.setEstado(result.getString("estado"));
                end.setRua(result.getString("rua"));
                end.setNumeroResidencia(Integer.parseInt(result.getString("numero")));
                result.close();
            }
            else
            {   System.out.println( "Endere�o n�o encontrado!\n" );
                end = null;
            }
            statement.close();
        }
        catch (SQLException e){ 
        	System.out.println("Problemas com o SQL de consulta de Pessoa F�sica !"); 
        }
        return end;
    }
		
	
	
	
	public void excluir(int id) {
		try {
			Statement stmt = getConnection().createStatement();
			String sqlExcluir = "DELETE FROM Endereco WHERE idEndereco = "+id+";";
			stmt.execute(sqlExcluir);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar");
			e.printStackTrace();
		}
	}
	
}
