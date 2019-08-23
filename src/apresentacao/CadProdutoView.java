package apresentacao;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import model.*;

public class CadProdutoView extends JFrame{
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelDescricao, jLabelQuantidade, jLabelValor;
	private JTextField jTextFieldDescricao, jTextFieldQuantidade,jTextFieldValor;
	private JButton btnSalvar, btnListar, btnFechar, btnLimpar, btnExcluir;
	
	String Descricao; 
	int quantidade;
	float valor;
	
	Produto produto;
	Endereco endereco;
	
	public CadProdutoView() {
		this.setTitle("Tela Produto");
		this.setSize(320,500);
		this.setLocationRelativeTo(null); 
		this.setResizable(true);
		this.setVisible(true);
		
		Container container = getContentPane();
		JPanel panel = new JPanel();
		container.add(panel);
		
		jLabelDescricao = new JLabel("Descricao: ");
		jTextFieldDescricao = new JTextField(50);
		panel.add(jLabelDescricao);
		panel.add(jTextFieldDescricao);
		
		jLabelQuantidade = new JLabel("Quantidade: ");
		jTextFieldQuantidade= new JTextField(50);
		panel.add(jLabelQuantidade);
		panel.add(jTextFieldQuantidade);
		
		jLabelValor = new JLabel("Valor: ");
		jTextFieldValor = new JTextField(20);
		panel.add(jLabelValor);
		panel.add( jTextFieldValor);
		
		btnSalvar = new JButton("Salvar");
		btnListar= new JButton("Listar");
		btnFechar = new JButton("Fechar");
		btnLimpar = new JButton("Limpar");
		btnExcluir = new JButton("Excluir");
		
		class BatSinal extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == btnSalvar) {
					Descricao = jTextFieldDescricao.getText();
					quantidade = Integer.parseInt(jTextFieldQuantidade.getText());
					valor = Float.parseFloat(jTextFieldValor.getText());
					produto = new Produto(Descricao, valor, quantidade);			
					jTextFieldDescricao.setText(""); 
					jTextFieldQuantidade.setText(""); 
					jTextFieldValor.setText("");
					JOptionPane.showMessageDialog(null, "Cadastro com sucesso!");

				}
					
				if (e.getSource() == btnLimpar) {				
					jTextFieldDescricao.setText(""); 
					jTextFieldQuantidade.setText(""); 
					jTextFieldValor.setText("");
				}
				
				if (e.getSource() == btnListar)
				{	
					Descricao = jTextFieldDescricao.getText();
					produto = new Produto(Descricao);
					if (Descricao.equals("")) {
						produto.listarProdutos();
					}else {
						produto.consultar();
						if (produto.getIdProduto()>0) {
							produto.imprimir();
						} else {
							JOptionPane.showMessageDialog(null, "Produto não encontrado!");
						}
					}
				}
				
				if (e.getSource() == btnExcluir)
				{	
					Descricao = jTextFieldDescricao.getText();
					produto = new Produto(Descricao);
					produto.consultar();
					if (produto.getIdProduto() > 0) {
						String[] options = {"Sim", "Não"};
						int resultado = JOptionPane.showOptionDialog(null, "Produto encontrado.\nID: "+produto.getIdProduto()+"\nQuantidade: "+produto.getQuantidade()+"\nDescricao: "+produto.getDescricao(), "Excluir Produto", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
						if (resultado == 0) {
							produto.excluir();
							if(produto.consultar() == null) {
								JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Produto não encontrado!");
					}		
				}
				
				if (e.getSource() == btnFechar) {
					dispose();
				}
				
			}
		}
				
		
		//adicionando ouvinte para os botÃµes
		BatSinal batman = new BatSinal();
		btnSalvar.addMouseListener(batman);
		btnListar.addMouseListener(batman);
		btnFechar.addMouseListener(batman);
		btnLimpar.addMouseListener(batman);
		btnExcluir.addMouseListener(batman);
		
		//Adicionando botões ao painel
		panel.add(btnSalvar);		panel.add(btnListar);
		panel.add(btnFechar);
		panel.add(btnLimpar);
		panel.add(btnExcluir);
		
						
		this.repaint();		
	}
}
