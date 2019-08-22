package apresentacao;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import model.*;

public class CadClientView extends JFrame{
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelCpf, jLabelNome, jLabelDataNascimento, jLabelRua, jLabelTelefone, jLabelNumero, jLabelBairro, jLabelCidade, jLabelEstado;
	private JTextField jTextFieldCpf, jTextFieldNome, jTextFieldDataNascimento, jTextFieldRua, jTextFieldTelefone, jTextFieldNumero, jTextFieldBairro, jTextFieldCidade, jTextFieldEstado;
	private JButton btnSalvar, btnListar, btnFechar, btnLimpar, btnExcluir;
	
	String cpf, nome, telefone, rua, dataNascimento, bairro, cidade, estado;
	int numero;
	
	Cliente cliente;
	Endereco endereco;
	
	public CadClientView() {
		this.setTitle("Tela Cliente");
		this.setSize(320,500);
		this.setLocationRelativeTo(null); 
		this.setResizable(true);
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
		
		jLabelTelefone = new JLabel("Telefone: ");
		jTextFieldTelefone = new JTextField(50);
		panel.add(jLabelTelefone);
		panel.add(jTextFieldTelefone);
		
		jLabelDataNascimento = new JLabel("Data Nascimento: ");
		jTextFieldDataNascimento = new JTextField(50);
		panel.add(jLabelDataNascimento);
		panel.add(jTextFieldDataNascimento);
		
		jLabelRua = new JLabel("Rua: ");
		jTextFieldRua = new JTextField(50);
		panel.add(jLabelRua);
		panel.add(jTextFieldRua);
		
		jLabelNumero = new JLabel("Numero: ");
		jTextFieldNumero = new JTextField(50);
		panel.add(jLabelNumero);
		panel.add(jTextFieldNumero);
		
		jLabelBairro = new JLabel("Bairro: ");
		jTextFieldBairro = new JTextField(30);
		panel.add(jLabelBairro);
		panel.add( jTextFieldBairro);
		
		jLabelCidade = new JLabel("Cidade: ");
		jTextFieldCidade = new JTextField(30);
		panel.add(jLabelCidade);
		panel.add( jTextFieldCidade);
		
		jLabelEstado = new JLabel("Estado: ");
		jTextFieldEstado = new JTextField(20);
		panel.add(jLabelEstado);
		panel.add( jTextFieldEstado);
		
		btnSalvar = new JButton("Salvar");
		btnListar= new JButton("Listar");
		btnFechar = new JButton("Fechar");
		btnLimpar = new JButton("Limpar");
		btnExcluir = new JButton("Excluir");
		
		class BatSinal extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == btnSalvar) {
					//endereco
					rua = jTextFieldRua.getText();
					numero = Integer.parseInt(jTextFieldNumero.getText());
					bairro =  jTextFieldBairro.getText();
					cidade = jTextFieldCidade.getText();
					estado = jTextFieldEstado.getText();
					endereco = new Endereco(rua,numero,bairro,cidade, estado);

					//telefone
					telefone =  jTextFieldTelefone.getText();
					
					//pessoal
					cpf = jTextFieldCpf.getText();
					nome = jTextFieldNome.getText();
					dataNascimento = jTextFieldDataNascimento.getText();		
					cliente = new Cliente(nome, cpf, telefone, dataNascimento, endereco);		
					
					ClienteEndereco clienteEndereco = new ClienteEndereco(cliente, endereco);
				}
					
				if (e.getSource() == btnLimpar) {				
					jTextFieldCpf.setText(""); 
					jTextFieldNome.setText(""); 
					jTextFieldDataNascimento.setText(""); 
					jTextFieldRua.setText(""); 
					jTextFieldTelefone.setText(""); 
					jTextFieldNumero.setText(""); 
					jTextFieldBairro.setText(""); 
					jTextFieldCidade.setText(""); 
					jTextFieldEstado.setText("");
				}
				
				if (e.getSource() == btnListar)
				{	
					cpf = jTextFieldCpf.getText();
					cliente = new Cliente(cpf);
					System.out.println("Instanciou o cliente!");
					cliente.consultar();
					System.out.println("Realizou a consulta!");
					if (cliente.getNome() != null) {
						cliente.imprimir();
					} else {
						JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
					}		
				}
				
				if (e.getSource() == btnExcluir)
				{	
					cpf = jTextFieldCpf.getText();
					cliente = new Cliente(cpf);
					cliente.consultar();
					if (cliente.getIdCliente() > 0) {
						String[] options = {"Sim", "Não"};
						int resultado = JOptionPane.showOptionDialog(null, "Cliente encontrado.\nID: "+cliente.getIdCliente()+"\nNome: "+cliente.getNome()+"\nCPF: "+cliente.getCpf(), "Excluir Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
						if (resultado == 0) {
							ClienteEndereco ce = new ClienteEndereco(cliente, cliente.getAtRefEndereco());
							ce.excluir();
							cliente.excluir();
							if(cliente.consultar() == null) {
								JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
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
