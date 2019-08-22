package apresentacao;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


public class RelatorioProdutos extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton btnFechar;
	
	public RelatorioProdutos(String relatorio) {
		this.setTitle("Relatório Produtos");
		this.setSize(400,600);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setVisible(true);

		Container container = getContentPane();
		JPanel panel = new JPanel();
		container.add(panel);
	
		JTextPane tp = new JTextPane();
        tp.setSize(500, 600);
        tp.setContentType("text/html");
        tp.setText(relatorio);	        
        
        JScrollPane sp = new JScrollPane(tp);
        
        this.getContentPane().add(BorderLayout.CENTER,sp);
        
		btnFechar = new JButton("Fechar");
		
		class BatSinal extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == btnFechar) {
					dispose();
				}
			}
		}
		
		BatSinal batman = new BatSinal();
		btnFechar.addMouseListener(batman);
		panel.add(btnFechar);
		
	}
	
}
