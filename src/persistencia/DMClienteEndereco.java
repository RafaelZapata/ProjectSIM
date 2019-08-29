package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.*;

public class DMClienteEndereco extends DMGeral{

	@Override
	public boolean incluir(Object obj) {
		ClienteEndereco objClienteEndereco = (ClienteEndereco) obj;
		String incluirSqlClienteEndereco = "INSERT INTO ClienteEndereco (FK_Cliente_idCliente, FK_Endereco_idEndereco) VALUES (?, ?)";
		try {
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlClienteEndereco);
			pStmt.setInt(1, objClienteEndereco.getAtRefCliente().getIdCliente());
			pStmt.setInt(2, objClienteEndereco.getAtRefEndereco().getIdEndereco());
			pStmt.executeUpdate();		
			pStmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}

	@Override
	public Object consultar(Object obj) {
		return obj;
	}
	
	public int pesquisar(int idCliente) {
		int idEndereco = 0;
    	try{   
    		Statement statement = getConnection().createStatement();
            
    		//montagem da String SQL de consulta na tabela        	
    		String consultarSqlClienteEndereco = "SELECT FK_Endereco_idEndereco from ClienteEndereco FK_Cliente_idCliente = ("+idCliente+")";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSqlClienteEndereco));
            ResultSet result = statement.executeQuery(consultarSqlClienteEndereco);
            if (result.next()){   
                idEndereco = Integer.parseInt(result.getString("FK_Endereco_idEndereco"));
                result.close();
            }
            else
            {   System.out.println( "Endereço não encontrado!\n" );
                idEndereco = -1;
            }
            statement.close();
        }
        catch (SQLException e){ 
        	System.out.println("Problemas com o SQL de consulta de Pessoa Física !"); 
        }
        return idEndereco;
    }
	
	public boolean excluir(int id) {
		try {
			Statement stmt = getConnection().createStatement();
			String sqlExcluir = "DELETE FROM ClienteEndereco WHERE FK_Cliente_idCliente = "+id+";";
			stmt.execute(sqlExcluir);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
