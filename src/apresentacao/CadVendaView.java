package apresentacao;

import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import model.*;

public class CadVendaView extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel jLabelidVendedor, jLabelidCliente, jLabelData, jLabelIdListar, jLabelidVendaCancelar;
	private JTextField jTextFieldidVendedor, jTextFieldidCliente, jTextFieldData, jTextFieldIdListar, jTextFieldidVendaCancelar;
	private JButton btnIniciar, btnListar, btnFechar, btnLimpar, btnCancelar;
	
	String data;
	int id, idVenda, idVendedor, idCliente;
	
	Vendas vendas;
	
	public CadVendaView() {
		this.setTitle("Venda");
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
		
		JPanel pCancelar = new JPanel();
		pCancelar.setSize(565,60);
		pCancelar.setLocation(10, 200); 
		pCancelar.setBorder(BorderFactory.createTitledBorder(" CANCELAR VENDA "));
		pCancelar.setLayout(null);
		container.add(pCancelar);
		
		JPanel panel = new JPanel();
		panel.setSize(90,50);
		panel.setLocation(475,280); 
		container.add(panel);
		
		//Entradas de inclusao
		jLabelidVendedor = new JLabel("Id do Vendedor: ");
		jLabelidVendedor.setSize(100, 20);
		jLabelidVendedor.setLocation(10, 20);
		
		jTextFieldidVendedor = new JTextField(12); 
		jTextFieldidVendedor.setSize(40, 20);
		jTextFieldidVendedor.setLocation(105, 23);
		
		pIncluir.add(jLabelidVendedor);
		pIncluir.add(jTextFieldidVendedor);
		
		jLabelidCliente = new JLabel("Id do Cliente: ");
		jLabelidCliente.setSize(80, 20);
		jLabelidCliente.setLocation(160, 20);
		
		jTextFieldidCliente= new JTextField();
		jTextFieldidCliente.setSize(40, 20);
		jTextFieldidCliente.setLocation(240, 23);
		
		pIncluir.add(jLabelidCliente);
		pIncluir.add(jTextFieldidCliente);
		
		jLabelData = new JLabel("Data: ");
		jLabelData.setSize(40, 20);
		jLabelData.setLocation(10, 50);
		
		jTextFieldData = new JTextField(50);
		jTextFieldData.setSize(80, 20);
		jTextFieldData.setLocation(45, 53);
		jTextFieldData.setText("dd-mm-aaaa");
		
		pIncluir.add(jLabelData);
		pIncluir.add(jTextFieldData);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setSize(80, 25);
		btnIniciar.setLocation(380, 65);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setSize(80, 25);
		btnLimpar.setLocation(465, 65);
		
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
		jLabelidVendaCancelar = new JLabel("Id da Venda: ");
		jLabelidVendaCancelar.setSize(80, 20);
		jLabelidVendaCancelar.setLocation(10, 20);
		
		jTextFieldidVendaCancelar = new JTextField(12); 
		jTextFieldidVendaCancelar.setSize(40, 20);
		jTextFieldidVendaCancelar.setLocation(90, 23);
		
		pCancelar.add(jLabelidVendaCancelar);
		pCancelar.add(jTextFieldidVendaCancelar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(85, 25);
		btnCancelar.setLocation(460, 20);
		
		btnFechar = new JButton("Fechar");
		
		
		class BatSinal extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == btnIniciar) {
					//pessoal
					idVendedor = Integer.parseInt(jTextFieldidVendedor.getText());
					idCliente = Integer.parseInt(jTextFieldidCliente.getText());
					Cliente cliente = new Cliente(idCliente);
					cliente.consultar();
					Vendedor vendedor = new Vendedor(idVendedor);
					vendedor.consultar();
					if(cliente.getCpf() == null){
						JOptionPane.showMessageDialog(null, "Cliente n„o cadastrado!");
					}else if (vendedor.getCpf() == null){
						JOptionPane.showMessageDialog(null, "Vendedor n„o cadastrado!");
					}else {
						data = jTextFieldData.getText();		
						vendas = new Vendas(idCliente, idVendedor, data);
						@SuppressWarnings("unused")
						CadVendaViewIncluir cv = new CadVendaViewIncluir(vendas);
						
						//Executar o botao limpar - Mas como n„o est· funcionando, vamos apenas colar o codigo
						jTextFieldidVendedor.setText(""); 
						jTextFieldidCliente.setText(""); 
						jTextFieldData.setText(""); 
					}
					
				}
					
				if (e.getSource() == btnLimpar) {				
					jTextFieldidVendedor.setText(""); 
					jTextFieldidCliente.setText(""); 
					jTextFieldData.setText(""); 
				}
				
				if (e.getSource() == btnListar)
				{	
					vendas = new Vendas();
					idVenda = Integer.parseInt(jTextFieldIdListar.getText());
					vendas.setIdVenda(idVenda);
					vendas.consultar();
					if (vendas.getValorVenda() > 0) {
						vendas.imprimir();
					} else {
						JOptionPane.showMessageDialog(null, "Venda n„o encontrada!");
					}		
				}
				
				if (e.getSource() == btnCancelar)
				{	
					id = Integer.parseInt(jTextFieldidVendaCancelar.getText());
					vendas = new Vendas();
					vendas.setIdVenda(id);
					vendas.consultar();
					if ((vendas.getValorVenda() > 0) && (vendas.isStatus() == true)) {
						String[] options = {"Sim", "N„o"};
						int resultado = JOptionPane.showOptionDialog(null, "Venda encontrada.\nID: "+vendas.getIdVenda()+"\nidCliente: "+vendas.getIdCliente()+"\nId Vendedor: "+vendas.getIdVendedor(), "Cancelar Venda", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
						if (resultado == 0) {
							vendas.cancelarVenda();
							if(vendas.consultar() == null) {
								JOptionPane.showMessageDialog(null, "Venda cancelada com sucesso!");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Venda n„o encontrada ou j· cancelada!");
					}		
				}
				
				if (e.getSource() == btnFechar) {
					dispose();
				}
				
			}
		}
				
		
		//adicionando ouvinte para os bot√µes
		BatSinal batman = new BatSinal();
		btnIniciar.addMouseListener(batman);
		btnListar.addMouseListener(batman);
		btnFechar.addMouseListener(batman);
		btnLimpar.addMouseListener(batman);
		btnCancelar.addMouseListener(batman);
		
		//Adicionando botıes ao painel
		pIncluir.add(btnIniciar);		pListar.add(btnListar);
		panel.add(btnFechar);
		pIncluir.add(btnLimpar);
		pCancelar.add(btnCancelar);
		
						
		this.repaint();		
	}
}
