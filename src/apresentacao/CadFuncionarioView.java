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
	private JLabel jLabelCpf, jLabelNome, jLabelDataAdmissao, jLabelSalario;
	private JTextField jTextFieldCpf, jTextFieldNome, jTextFieldDataAdmissao, jTextFieldSalario;
	private JButton btnSalvar, btnListar, btnFechar, btnLimpar, btnExcluir;
	
	String cpf, nome, dataAdmissao;
	float salario;
	
	Vendedor vendedor;
	Endereco endereco;
	
	public CadFuncionarioView() {
		this.setTitle("Tela Vendedor");
		this.setSize(320,500);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setVisible(true);
		
		Container container = getContentPane();
		JPanel panel = new JPanel();
		container.add(panel);
		
		jLabelCpf = new JLabel("Cpf: ");
		jTextFieldCpf = new JTextField(50);
		panel.add(jLabelCpf);
		panel.add(jTextFieldCpf);
		
		jLabelNome = new JLabel("Nome: ");
		jTextFieldNome= new JTextField(50);
		panel.add(jLabelNome);
		panel.add(jTextFieldNome);
		
		jLabelDataAdmissao = new JLabel("Data Admissao: ");
		jTextFieldDataAdmissao = new JTextField(50);
		panel.add(jLabelDataAdmissao);
		panel.add(jTextFieldDataAdmissao);
		
		jLabelSalario = new JLabel("Salario: ");
		jTextFieldSalario = new JTextField(20);
		panel.add(jLabelSalario);
		panel.add( jTextFieldSalario);
		
		btnSalvar = new JButton("Salvar");
		btnListar= new JButton("Listar");
		btnFechar = new JButton("Fechar");
		btnLimpar = new JButton("Limpar");
		btnExcluir = new JButton("Excluir");
		
		class BatSinal extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == btnSalvar) {
					cpf = jTextFieldCpf.getText();
					nome = jTextFieldNome.getText();
					dataAdmissao = jTextFieldDataAdmissao.getText();
					salario = Float.parseFloat(jTextFieldSalario.getText());
					vendedor = new Vendedor(nome, cpf, salario, dataAdmissao);	
				}
					
				if (e.getSource() == btnLimpar) {				
					jTextFieldCpf.setText(""); 
					jTextFieldNome.setText(""); 
					jTextFieldDataAdmissao.setText(""); 
					jTextFieldSalario.setText("");
				}
				
				if (e.getSource() == btnListar)
				{	
					cpf = jTextFieldCpf.getText();
					vendedor = new Vendedor(cpf);
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
		panel.add(btnSalvar);		panel.add(btnListar);
		panel.add(btnFechar);
		panel.add(btnLimpar);
		panel.add(btnExcluir);
		
						
		this.repaint();		
	}
}
