package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import SimpleInventoryManagement.*;

public class CadClientView extends JFrame{
	private JLabel jLabelCpf, jLabelNome, jLabelDataNascimento, jLabelRua, jLabelTelefone;
	private JTextField jTextFieldCpf, jTextFieldNome, jTextFieldDataNascimento, jTextFieldRua, jTextFieldTelefone;
	private JButton btnSalvar;
	
	String cpf, nome, telefone, rua, dataNascimento;
	
	Cliente cliente;
	Endereco endereco;
	
	public CadClientView() {
		this.setTitle("Tela Criente");
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
		
		btnSalvar = new JButton("Salvar");
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rua = jTextFieldRua.getText();
//				endereco = new Endereco(rua); Falta adicionar os parametros do construtor de endereço
				
				cpf = jTextFieldCpf.getText();
				nome = jTextFieldNome.getText();
				dataNascimento = jTextFieldDataNascimento.getText();
				telefone = jTextFieldTelefone.getText();
				cliente = new Cliente(nome, cpf, dataNascimento, telefone, endereco);
				
			}
		});
		
		panel.add(btnSalvar);
						
		this.repaint();		
	}
}
