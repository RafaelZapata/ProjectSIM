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
	private JButton btnSalvar, btnIncluir, btnRemover, btnCancelar;
	private String relatorio = "";

	int quantidade, id;
	
	public CadVendaViewIncluir(Vendas venda) {
		this.setTitle("Carrinho");
		this.setSize(535,395);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(null);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("../ProjectSIM/src/images/carrinho.png");
	    this.setIconImage(img);
		
		Container container = getContentPane();
		
		JPanel pIncluir = new JPanel();
		pIncluir.setSize(500,150);
		pIncluir.setLocation(10,10); 
		pIncluir.setBorder(BorderFactory.createTitledBorder(" ADICIONAR PRODUTOS "));
		pIncluir.setLayout(null);
		container.add(pIncluir);
		
		JPanel panel = new JPanel();
		panel.setSize(500, 200);
		panel.setLocation(10, 165);
		panel.setBorder(BorderFactory.createTitledBorder(" CARRINHO "));
		panel.setLayout(null);
		container.add(panel);
	
		JTextPane tp = new JTextPane();
        tp.setSize(400, 180);
        tp.setContentType("text/html");
        tp.setText("Sem itens no carrinho.");	        
        
        panel.setLayout(new BorderLayout());
        panel.setVisible(true);
        
        panel.setBounds(10, 165, 500, 180);
        panel.setPreferredSize(new Dimension(500, 200));
         
        final JScrollPane scrollp = new JScrollPane(tp, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollp);

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
		btnSalvar.setLocation(10, 110);
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.setSize(80, 25);
		btnIncluir.setLocation(100, 110);
		
		btnRemover = new JButton("Remover");
		btnRemover.setSize(85, 25);
		btnRemover.setLocation(200, 110);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(85, 25);
		btnCancelar.setLocation(300, 110);	
		
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
					if(venda.addProduto(id, quantidade)) {
						JOptionPane.showMessageDialog(null, "Produto incluido com sucesso!");
//						for(ListaProdutos lp : venda.getList()) {
//							Produto pro = new Produto(lp.getIdProduto());
//							pro.consultar();
//							pro.setQuantidade(lp.getQuantidade());
//							relatorio += pro.toString();
//						}
//						tp.setText(relatorio);
						attCarrinho(venda, relatorio, tp);
					}else JOptionPane.showMessageDialog(null, "Falha ao inserir.");
					
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
					attCarrinho(venda, relatorio, tp);
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
		btnRemover.addMouseListener(batman);
		btnCancelar.addMouseListener(batman);
		
		//Adicionando botıes ao painel
		pIncluir.add(btnIncluir);
		pIncluir.add(btnSalvar);
		pIncluir.add(btnRemover);
		pIncluir.add(btnCancelar);
		
						
		this.repaint();		
	}
	
	public void attCarrinho(Vendas venda, String relatorio, JTextPane tp) {
		for(ListaProdutos lp : venda.getList()) {
			Produto pro = new Produto(lp.getIdProduto());
			pro.consultar();
			pro.setQuantidade(lp.getQuantidade());
			relatorio += pro.toString();
		}
		tp.setText(relatorio);	
	}
}
