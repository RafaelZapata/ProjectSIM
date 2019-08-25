package apresentacao;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import model.*;

public class CadFuncionarioView extends JFrame{
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelCpf, jLabelNome, jLabelDataAdmissao, jLabelSalario, jLabelIdListar, jLabelCpfListar, jLabelNomeListar, jLabelCpfExcluir;
	private JTextField jTextFieldCpf, jTextFieldNome, jTextFieldDataAdmissao, jTextFieldSalario, jTextFieldCpfExcluir, jTextFieldNomeListar, jTextFieldCpfListar, jTextFieldIdListar;
	private JButton btnSalvar, btnListar, btnFechar, btnLimpar, btnExcluir;
	
	String cpf, nome, dataAdmissao;
	float salario;
	int id;
	
	Vendedor vendedor;
	Endereco endereco;
	
	public CadFuncionarioView() {
		this.setTitle("Tela Funcionário");
		this.setSize(600,420);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(null);
		
		Container container = getContentPane();
		
		JPanel pIncluir = new JPanel();
		pIncluir.setSize(565,120);
		pIncluir.setLocation(10,10); 
		pIncluir.setBorder(BorderFactory.createTitledBorder(" NOVO FUNCIONÁRIO "));
		pIncluir.setLayout(null);
		container.add(pIncluir);
		
		JPanel pListar = new JPanel();
		pListar.setSize(565,120);
		pListar.setLocation(10,135); 
		pListar.setBorder(BorderFactory.createTitledBorder(" PESQUISAR "));
		pListar.setLayout(null);
		container.add(pListar);
		
		JPanel pExcluir = new JPanel();
		pExcluir.setSize(565,60);
		pExcluir.setLocation(10,270); 
		pExcluir.setBorder(BorderFactory.createTitledBorder(" REMOVER FUNCIONÁRIO "));
		pExcluir.setLayout(null);
		container.add(pExcluir);
		
		JPanel panel = new JPanel();
		panel.setSize(90,50);
		panel.setLocation(490,335); 
		container.add(panel);
		
		//Entradas de inclusao
		jLabelCpf = new JLabel("Cpf: ");
		jLabelCpf.setSize(35, 20);
		jLabelCpf.setLocation(10, 20);
		
		jTextFieldCpf = new JTextField(12); 
		jTextFieldCpf.setSize(155, 20);
		jTextFieldCpf.setLocation(40, 23);
		
		pIncluir.add(jLabelCpf);
		pIncluir.add(jTextFieldCpf);
		
		jLabelNome = new JLabel("Nome: ");
		jLabelNome.setSize(50, 20);
		jLabelNome.setLocation(210, 20);
		
		jTextFieldNome= new JTextField();
		jTextFieldNome.setSize(250, 20);
		jTextFieldNome.setLocation(255, 23);
		
		pIncluir.add(jLabelNome);
		pIncluir.add(jTextFieldNome);
		
		jLabelDataAdmissao = new JLabel("Data Admissão: ");
		jLabelDataAdmissao.setSize(110, 20);
		jLabelDataAdmissao.setLocation(10, 50);
		
		jTextFieldDataAdmissao = new JTextField(50);
		jTextFieldDataAdmissao.setSize(80, 20);
		jTextFieldDataAdmissao.setLocation(115, 53);
		jTextFieldDataAdmissao.setText("dd-mm-aaaa");
		
		pIncluir.add(jLabelDataAdmissao);
		pIncluir.add(jTextFieldDataAdmissao);
		
		jLabelSalario = new JLabel("Salario: ");
		jLabelSalario.setSize(70, 20);
		jLabelSalario.setLocation(210, 50);
		
		jTextFieldSalario = new JTextField(50);
		jTextFieldSalario.setSize(150, 20);
		jTextFieldSalario.setLocation(270, 53);
		
		pIncluir.add(jLabelSalario);
		pIncluir.add(jTextFieldSalario);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setSize(80, 25);
		btnSalvar.setLocation(370, 80);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setSize(80, 25);
		btnLimpar.setLocation(455, 80);
		
		//Entradas da tela de pesquisar
		jLabelIdListar = new JLabel("Id: ");
		jLabelIdListar.setSize(35, 20);
		jLabelIdListar.setLocation(10, 20);
		
		jTextFieldIdListar = new JTextField(12); 
		jTextFieldIdListar.setSize(50, 20);
		jTextFieldIdListar.setLocation(40, 23);
		
		pListar.add(jLabelIdListar);
		pListar.add(jTextFieldIdListar);
		
		jLabelCpfListar = new JLabel("Cpf: ");
		jLabelCpfListar.setSize(35, 20);
		jLabelCpfListar.setLocation(10, 50);
		
		jTextFieldCpfListar = new JTextField(12); 
		jTextFieldCpfListar.setSize(155, 20);
		jTextFieldCpfListar.setLocation(40, 53);
		
		pListar.add(jLabelCpfListar);
		pListar.add(jTextFieldCpfListar);
		
		jLabelNomeListar = new JLabel("Nome: ");
		jLabelNomeListar.setSize(50, 20);
		jLabelNomeListar.setLocation(10, 80);
		
		jTextFieldNomeListar = new JTextField();
		jTextFieldNomeListar.setSize(250, 20);
		jTextFieldNomeListar.setLocation(55, 83);
		
		pListar.add(jLabelNomeListar);
		pListar.add(jTextFieldNomeListar);
		
		btnListar= new JButton("Listar");
		btnListar.setSize(80, 25);
		btnListar.setLocation(455, 80);
		
		//Entradas da tela Excluir
		jLabelCpfExcluir = new JLabel("Cpf: ");
		jLabelCpfExcluir.setSize(35, 20);
		jLabelCpfExcluir.setLocation(10, 20);
		
		jTextFieldCpfExcluir = new JTextField(12); 
		jTextFieldCpfExcluir.setSize(155, 20);
		jTextFieldCpfExcluir.setLocation(40, 23);
		
		pExcluir.add(jLabelCpfExcluir);
		pExcluir.add(jTextFieldCpfExcluir);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setSize(80, 25);
		btnExcluir.setLocation(455, 20);
		
		btnFechar = new JButton("Fechar");
		
		class BatSinal extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == btnSalvar) {
					cpf = jTextFieldCpf.getText();
					nome = jTextFieldNome.getText();
					dataAdmissao = jTextFieldDataAdmissao.getText();
					salario = Float.parseFloat(jTextFieldSalario.getText());
					vendedor = new Vendedor(nome, cpf, salario, dataAdmissao);	
					
					//Executar o botao limpar - Mas como não está funcionando, vamos apenas colar o codigo
					jTextFieldCpf.setText(""); 
					jTextFieldNome.setText(""); 
					jTextFieldDataAdmissao.setText(""); 
					jTextFieldSalario.setText("");
				}
					
				if (e.getSource() == btnLimpar) {				
					jTextFieldCpf.setText(""); 
					jTextFieldNome.setText(""); 
					jTextFieldDataAdmissao.setText(""); 
					jTextFieldSalario.setText("");
				}
				
				if (e.getSource() == btnListar)
				{	
					vendedor = new Vendedor();
					cpf = jTextFieldCpfListar.getText();
					vendedor.setCpf(cpf);
					if(!jTextFieldIdListar.getText().equals("")) {
						id = Integer.parseInt(jTextFieldIdListar.getText());
						vendedor.setIdVendedor(id);
					}	
					if(!jTextFieldNomeListar.getText().equals("")) {
						nome = jTextFieldNomeListar.getText();
						vendedor.setNome(nome);
					}
					System.out.println("Instanciou o vendedor!");
					vendedor.consultar();
					System.out.println("Realizou a consulta!");
					if (vendedor.getNome() != null) {
						vendedor.imprimir();
					} else {
						JOptionPane.showMessageDialog(null, "Vendedor não encontrado!");
					}		
				}
				
				if (e.getSource() == btnExcluir)
				{	
					cpf = jTextFieldCpf.getText();
					vendedor = new Vendedor(cpf);
					vendedor.consultar();
					if (vendedor.getIdVendedor() > 0) {
						String[] options = {"Sim", "Não"};
						int resultado = JOptionPane.showOptionDialog(null, "Vendedor encontrado.\nID: "+vendedor.getIdVendedor()+"\nNome: "+vendedor.getNome()+"\nCPF: "+vendedor.getCpf(), "Excluir Vendedor", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
						if (resultado == 0) {
							vendedor.excluir();
							if(vendedor.consultar() == null) {
								JOptionPane.showMessageDialog(null, "Vendedor excluído com sucesso!");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Vendedor não encontrado!");
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
		pIncluir.add(btnSalvar);		pIncluir.add(btnLimpar);
		pListar.add(btnListar);
		pExcluir.add(btnExcluir);
		panel.add(btnFechar);
		
						
		this.repaint();		
	}
}
