package SimpleInventoryManagement;

import Util.DatabaseConnect;

public class teste {
	
	public static void main(String[] args) {
		
		DatabaseConnect Connect = new DatabaseConnect();
//		Declaração de variaveis e objetos
//		Produto[] Lista = new Produto[3];
		Vendedor p1 = new Vendedor();
		p1.novo_cadastro();
		
		Connect.connection();
	}
}
