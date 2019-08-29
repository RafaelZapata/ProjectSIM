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
	private JLabel jLabelDescricao, jLabelQuantidade, jLabelValor, jLabelDescricaoListar, jLabelIdExcluir, jLabelDescricaoAlterar, jLabelQuantidadeAlterar, jLabelValorAlterar, jLabelIdAlterar;
	private JTextField jTextFieldDescricao, jTextFieldQuantidade,jTextFieldValor, jTextFieldDescricaoListar, jTextFieldIdExcluir, jTextFieldDescricaoAlterar, jTextFieldQuantidadeAlterar, jTextFieldValorAlterar, jTextFieldIdAlterar;
	private JButton btnSalvar, btnListar, btnFechar, btnLimpar, btnExcluir, btnAlterar;
	
	String Descricao; 
	int id, quantidade;
	float valor;
	
	Produto produto;
	Endereco endereco;
	
	public CadProdutoView() {
		this.setTitle("Tela Produto");
		this.setSize(600,455);
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
		pIncluir.setBorder(BorderFactory.createTitledBorder(" NOVO PRODUTO "));
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
		pExcluir.setBorder(BorderFactory.createTitledBorder(" EXCLUIR PRODUTO "));
		pExcluir.setLayout(null);
		container.add(pExcluir);
		
		JPanel pAlterar = new JPanel();
		pAlterar.setSize(565,95);
		pAlterar.setLocation(10, 270); 
		pAlterar.setBorder(BorderFactory.createTitledBorder(" ALTERAR PRODUTO "));
		pAlterar.setLayout(null);
		container.add(pAlterar);
		
		JPanel panel = new JPanel();
		panel.setSize(90,50);
		panel.setLocation(475,375); 
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
		jLabelDescricaoListar = new JLabel("Descricao: ");
		jLabelDescricaoListar.setSize(75, 20);
		jLabelDescricaoListar.setLocation(10, 20);
		
		jTextFieldDescricaoListar = new JTextField(12); 
		jTextFieldDescricaoListar.setSize(250, 20);
		jTextFieldDescricaoListar.setLocation(80, 23);
		
		pListar.add(jLabelDescricaoListar);
		pListar.add(jTextFieldDescricaoListar);
		
		btnListar= new JButton("Listar");
		btnListar.setSize(80, 25);
		btnListar.setLocation(465, 20);
		
		//Entradas da tela Cancelar
		jLabelIdExcluir = new JLabel("Id do Produto: ");
		jLabelIdExcluir.setSize(85, 20);
		jLabelIdExcluir.setLocation(10, 20);
		
		jTextFieldIdExcluir = new JTextField(12); 
		jTextFieldIdExcluir.setSize(40, 20);
		jTextFieldIdExcluir.setLocation(100, 23);
		
		pExcluir.add(jLabelIdExcluir);
		pExcluir.add(jTextFieldIdExcluir);
		
		btnExcluir = new JButton("Cancelar");
		btnExcluir.setSize(85, 25);
		btnExcluir.setLocation(460, 20);
		
		//Entradas de alteração
		jLabelIdAlterar = new JLabel("Id do Produto: ");
		jLabelIdAlterar.setSize(85, 20);
		jLabelIdAlterar.setLocation(10, 20);
		
		jTextFieldIdAlterar = new JTextField(12); 
		jTextFieldIdAlterar.setSize(40, 20);
		jTextFieldIdAlterar.setLocation(100, 23);
		
		pAlterar.add(jLabelIdAlterar);
		pAlterar.add(jTextFieldIdAlterar);
		
		jLabelDescricaoAlterar = new JLabel("Descricao: ");
		jLabelDescricaoAlterar.setSize(75, 20);
		jLabelDescricaoAlterar.setLocation(150, 20);
				
		jTextFieldDescricaoAlterar = new JTextField(12); 
		jTextFieldDescricaoAlterar.setSize(250, 20);
		jTextFieldDescricaoAlterar.setLocation(220, 23);
				
		pAlterar.add(jLabelDescricaoAlterar);
		pAlterar.add(jTextFieldDescricaoAlterar);
				
		jLabelValorAlterar = new JLabel("Valor: R$");
		jLabelValorAlterar.setSize(70, 20);
		jLabelValorAlterar.setLocation(150, 50);
				
		jTextFieldValorAlterar = new JTextField();
		jTextFieldValorAlterar.setSize(40, 20);
		jTextFieldValorAlterar.setLocation(210, 53);
				
		pAlterar.add(jLabelValorAlterar);
		pAlterar.add(jTextFieldValorAlterar);
				
		jLabelQuantidadeAlterar = new JLabel("Quantidade: ");
		jLabelQuantidadeAlterar.setSize(75, 20);
		jLabelQuantidadeAlterar.setLocation(10, 50);
				
		jTextFieldQuantidadeAlterar = new JTextField(50);
		jTextFieldQuantidadeAlterar.setSize(50, 20);
		jTextFieldQuantidadeAlterar.setLocation(90, 53);
				
		pAlterar.add(jLabelQuantidadeAlterar);
		pAlterar.add(jTextFieldQuantidadeAlterar);
				
		btnAlterar = new JButton("Alterar");
		btnAlterar.setSize(80, 25);
		btnAlterar.setLocation(465, 55);
		
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
					Descricao = jTextFieldDescricaoListar.getText();
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
					id = Integer.parseInt(jTextFieldIdExcluir.getText());
					produto = new Produto(id);
					produto.consultar();
					if (produto.getDescricao()!=null) {
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
				
				if (e.getSource() == btnAlterar) {		
					id = Integer.parseInt(jTextFieldIdAlterar.getText());
					Produto pro = new Produto(id);
					pro.consultar();
					if(pro.getDescricao()!=null) {
						if(!jTextFieldDescricaoAlterar.getText().equals("")) {
							Descricao = jTextFieldDescricaoAlterar.getText();
							pro.setDescricao(Descricao);
						}
						if(!jTextFieldValorAlterar.getText().equals("")) {
							valor = Float.parseFloat(jTextFieldValorAlterar.getText());
							pro.setValor(valor);
						}
						
						if(!jTextFieldQuantidadeAlterar.getText().equals("")) {
							quantidade = Integer.parseInt(jTextFieldQuantidadeAlterar.getText());
							pro.setQuantidade(quantidade);
						}
						pro.alterar();
					}
					jTextFieldDescricaoAlterar.setText(""); 
					jTextFieldQuantidadeAlterar.setText(""); 
					jTextFieldValorAlterar.setText("");
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
		btnAlterar.addMouseListener(batman);
		
		//Adicionando botões ao painel
		pIncluir.add(btnSalvar);		pListar.add(btnListar);
		panel.add(btnFechar);
		pIncluir.add(btnLimpar);
		pExcluir.add(btnExcluir);
		pAlterar.add(btnAlterar);
		
						
		this.repaint();		
	}
}
