package apresentacao;

import java.awt.*;
import javax.swing.*;


public class RelatorioProdutos extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public RelatorioProdutos(String relatorio) {
		this.setTitle("Relatório Produtos");
		this.setSize(400,600);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setVisible(true);
	
		JTextPane tp = new JTextPane();
        tp.setSize(500, 600);
        tp.setContentType("text/html");
        tp.setText(relatorio);	        
        
        JScrollPane sp = new JScrollPane(tp);
        
        this.getContentPane().add(BorderLayout.CENTER,sp);
		
	}
	
}
