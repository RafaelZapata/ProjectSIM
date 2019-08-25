package apresentacao;

import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import model.*;

public class CadVendaViewIncluir extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel jLabelidProduto, jLabelQuantidade;
	private JTextField jTextFieldidProduto, jTextFieldQuantidade;
	private JButton btnSalvar, btnIncluir, btnListar, btnRemover, btnCancelar;

	int quantidade, id;
	
	public CadVendaViewIncluir(Vendas venda) {
		this.setTitle("Carrinho");
		this.setSize(600,300);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(null);
		
		Container container = getContentPane();
		
		JPanel pIncluir = new JPanel();
		pIncluir.setSize(565,250);
		pIncluir.setLocation(10,10); 
		pIncluir.setBorder(BorderFactory.createTitledBorder(" ADICIONAR PRODUTOS "));
		pIncluir.setLayout(null);
		container.add(pIncluir);
		
		//Entradas de inclusao
		jLabelidProduto = new JLabel("Id Produto: ");
		jLabelidProduto.setSize(80, 20);
		jLabelidProduto.setLocation(10, 20);
		
		jTextFieldidProduto = new JTextField(12); 
		jTextFieldidProduto.setSize(155, 20);
		jTextFieldidProduto.setLocation(85, 23);
		
		pIncluir.add(jLabelidProduto);
		pIncluir.add(jTextFieldidProduto);
		
		jLabelQuantidade = new JLabel("Quantidade: ");
		jLabelQuantidade.setSize(80, 20);
		jLabelQuantidade.setLocation(10, 50);
		
		jTextFieldQuantidade= new JTextField();
		jTextFieldQuantidade.setSize(250, 20);
		jTextFieldQuantidade.setLocation(85, 53);
		
		pIncluir.add(jLabelQuantidade);
		pIncluir.add(jTextFieldQuantidade);

		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setSize(80, 25);
		btnSalvar.setLocation(10, 100);
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.setSize(80, 25);
		btnIncluir.setLocation(100, 100);
		
		btnRemover = new JButton("Remover");
		btnRemover.setSize(80, 25);
		btnRemover.setLocation(200, 100);
		
		btnListar= new JButton("Listar");
		btnListar.setSize(80, 25);
		btnListar.setLocation(300, 100);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(80, 25);
		btnCancelar.setLocation(400, 100);	
		
		class BatSinal extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == btnSalvar) {
					venda.incluir();
					//Executar o botao limpar - Mas como n„o est· funcionando, vamos apenas colar o codigo
					jTextFieldidProduto.setText(""); 
					jTextFieldQuantidade.setText(""); 
				}
					
				if (e.getSource() == btnIncluir) {
					id = Integer.parseInt(jTextFieldidProduto.getText());
					quantidade = Integer.parseInt(jTextFieldQuantidade.getText());
					venda.addProduto(id, quantidade);
					JOptionPane.showMessageDialog(null, "Produto incluido com sucesso!");
					
					//Executar o botao limpar - Mas como n„o est· funcionando, vamos apenas colar o codigo
					jTextFieldidProduto.setText(""); 
					jTextFieldQuantidade.setText(""); 
				}
				
				if (e.getSource() == btnRemover) {	
					id = Integer.parseInt(jTextFieldidProduto.getText());
					if(jTextFieldQuantidade.getText().equals("")) {
						quantidade = -1;
					}else {
						quantidade = Integer.parseInt(jTextFieldQuantidade.getText());						
					}
					venda.excluirProduto(id, quantidade);
				}
				
				if (e.getSource() == btnListar){
					if(venda.getList() != null) {
						String relatorio = "";
						for(ListaProdutos lp : venda.getList()) {
							Produto pro = new Produto(lp.getIdProduto());
							pro.consultar();
							pro.setQuantidade(lp.getQuantidade());
							relatorio += pro.toString();
						}
						RelatorioProdutos rp = new RelatorioProdutos(relatorio);
					}else {
						JOptionPane.showMessageDialog(null, "N„o h· produtos no carrinho!");
					}
				}
				
				if (e.getSource() == btnCancelar){	
					dispose();
				}
			}
		}
				
		
		//adicionando ouvinte para os bot√µes
		BatSinal batman = new BatSinal();
		btnIncluir.addMouseListener(batman);
		btnSalvar.addMouseListener(batman);
		btnListar.addMouseListener(batman);
		btnRemover.addMouseListener(batman);
		btnCancelar.addMouseListener(batman);
		
		//Adicionando botıes ao painel
		pIncluir.add(btnIncluir);
		pIncluir.add(btnSalvar);		pIncluir.add(btnListar);
		pIncluir.add(btnRemover);
		pIncluir.add(btnCancelar);
		
						
		this.repaint();		
	}
}
