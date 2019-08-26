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
	private JLabel jLabelDescricao, jLabelQuantidade, jLabelValor, jLabelIdListar, jLabeliCancelar;
	private JTextField jTextFieldDescricao, jTextFieldQuantidade,jTextFieldValor, jTextFieldIdListar, jTextFieldIdCancelar;
	private JButton btnSalvar, btnListar, btnFechar, btnLimpar, btnExcluir;
	
	String Descricao; 
	int quantidade;
	float valor;
	
	Produto produto;
	Endereco endereco;
	
	public CadProdutoView() {
		this.setTitle("Tela Produto");
		this.setSize(600,360);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(null);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("../ProjectSIM/src/images/loja.png");
	    this.setIconImage(img);
		
		Container container = getContentPane();
		
		JPanel pIncluir = new JPanel();
		pIncluir.setSize(565,100);
		pIncluir.setLocation(10,10); 
		pIncluir.setBorder(BorderFactory.createTitledBorder(" NOVA VENDA "));
		pIncluir.setLayout(null);
		container.add(pIncluir);
		
		JPanel pListar = new JPanel();
		pListar.setSize(565,60);
		pListar.setLocation(10,120); 
		pListar.setBorder(BorderFactory.createTitledBorder(" PESQUISAR "));
		pListar.setLayout(null);
		container.add(pListar);
		
		JPanel pExcluir = new JPanel();
		pExcluir.setSize(565,60);
		pExcluir.setLocation(10, 200); 
		pExcluir.setBorder(BorderFactory.createTitledBorder(" CANCELAR VENDA "));
		pExcluir.setLayout(null);
		container.add(pExcluir);
		
		JPanel panel = new JPanel();
		panel.setSize(90,50);
		panel.setLocation(490,280); 
		container.add(panel);
		
		btnSalvar = new JButton("Salvar");
		btnListar= new JButton("Listar");
		btnFechar = new JButton("Fechar");
		btnLimpar = new JButton("Limpar");
		btnExcluir = new JButton("Excluir");
		
		//Entradas de inclusao
		jLabelDescricao = new JLabel("Descricao: ");
		jLabelDescricao.setSize(75, 20);
		jLabelDescricao.setLocation(10, 20);
		
		jTextFieldDescricao = new JTextField(12); 
		jTextFieldDescricao.setSize(250, 20);
		jTextFieldDescricao.setLocation(80, 23);
		
		pIncluir.add(jLabelDescricao);
		pIncluir.add(jTextFieldDescricao);
		
		jLabelValor = new JLabel("Valor: R$");
		jLabelValor.setSize(70, 20);
		jLabelValor.setLocation(150, 50);
		
		jTextFieldValor= new JTextField();
		jTextFieldValor.setSize(40, 20);
		jTextFieldValor.setLocation(210, 53);
		
		pIncluir.add(jLabelValor);
		pIncluir.add(jTextFieldValor);
		
		jLabelQuantidade = new JLabel("Quantidade: ");
		jLabelQuantidade.setSize(75, 20);
		jLabelQuantidade.setLocation(10, 50);
		
		jTextFieldQuantidade = new JTextField(50);
		jTextFieldQuantidade.setSize(50, 20);
		jTextFieldQuantidade.setLocation(90, 53);
		
		pIncluir.add(jLabelQuantidade);
		pIncluir.add(jTextFieldQuantidade);
		
		btnSalvar = new JButton("Iniciar");
		btnSalvar.setSize(80, 25);
		btnSalvar.setLocation(380, 60);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setSize(80, 25);
		btnLimpar.setLocation(465, 60);
		
		//Entradas da tela de pesquisar
		jLabelIdListar = new JLabel("Id da Venda: ");
		jLabelIdListar.setSize(75, 20);
		jLabelIdListar.setLocation(10, 20);
		
		jTextFieldIdListar = new JTextField(12); 
		jTextFieldIdListar.setSize(40, 20);
		jTextFieldIdListar.setLocation(90, 23);
		
		pListar.add(jLabelIdListar);
		pListar.add(jTextFieldIdListar);
		
		btnListar= new JButton("Listar");
		btnListar.setSize(80, 25);
		btnListar.setLocation(465, 20);
		
		//Entradas da tela Cancelar
		jLabeliCancelar = new JLabel("Id da Venda: ");
		jLabeliCancelar.setSize(80, 20);
		jLabeliCancelar.setLocation(10, 20);
		
		jTextFieldIdCancelar = new JTextField(12); 
		jTextFieldIdCancelar.setSize(40, 20);
		jTextFieldIdCancelar.setLocation(90, 23);
		
		pExcluir.add(jLabeliCancelar);
		pExcluir.add(jTextFieldIdCancelar);
		
		btnExcluir = new JButton("Cancelar");
		btnExcluir.setSize(85, 25);
		btnExcluir.setLocation(460, 20);
		
		btnFechar = new JButton("Fechar");
		
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
		pIncluir.add(btnSalvar);		pListar.add(btnListar);
		panel.add(btnFechar);
		pIncluir.add(btnLimpar);
		pExcluir.add(btnExcluir);
		
						
		this.repaint();		
	}
}
