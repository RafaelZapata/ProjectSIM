package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import javax.swing.JOptionPane;

import java.sql.Date;

import SimpleInventoryManagement.*;
import Util.*;

public class Teste {

	public static void main(String[] args) {
//		CadClientView tela = new CadClientView();
//		java.util.Date d = new java.util.Date("09/06/1994");
//		java.sql.Date dt = new java.sql.Date(d.getTime());
//		Cliente cliente = new Cliente("Rafael", "10966589769", "22999921967", dt);
//		Produto pro1 = new Produto("Bola", 20, 10);
//		Produto pro2 = new Produto("Bola de basquete", 80, 5);
//		Produto pro3 = new Produto("Bola de tenis", 50, 15);
		DMProduto dmPro = new DMProduto();
		dmPro.pesquisar();
		
		

	}

}
