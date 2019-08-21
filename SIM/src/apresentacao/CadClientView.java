package apresentacao;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import model.*;

public class CadClientView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelCpf, jLabelNome, jLabelDataNascimento, jLabelRua, jLabelTelefone;
	private JTextField jTextFieldCpf, jTextFieldNome, jTextFieldDataNascimento, jTextFieldRua, jTextFieldTelefone;
	private JButton btnSalvar;
	
	String cpf, nome, telefone, rua, dataNascimento;
	
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
		
		btnSalvar = new JButton("Salvar");
		class BatSinal extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == btnSalvar) {
					System.out.println("ROLA!");
					//endereco
					rua = jTextFieldRua.getText();
//					end = new Endereco(rua,numero,complemento,bairro,cidade,cep,estado);

					//telefone
					telefone =  jTextFieldTelefone.getText();
					
					//pessoal
					cpf = jTextFieldCpf.getText();
					nome = jTextFieldNome.getText();
					@SuppressWarnings("deprecation")
					java.util.Date dataNascimento = new java.util.Date(jTextFieldDataNascimento.getText());			
					Cliente cliente = new Cliente(nome, cpf, telefone, dataNascimento);		
				}
				
//				if (e.getSource() == bLimpar) {
//					tNome.setText("");
//					tCpf.setText("");
//					tDataNascimento.setText("");
//					tRua.setText("");
//					tNumero.setText("");
//					tComplemento.setText("");
//					tBairro.setText("");
//					tCidade.setText("");
//					tCep.setText("");
//					tEstado.setText("");
//					tDdi.setText("");
//					tDdd.setText("");
//					tTel.setText("");
//					tTipo.setText("");
//					tOperadora.setText("");
//				}
//				
//				if (e.getSource() == bListar)
//				{	pf.imprimir();
//					JOptionPane.showMessageDialog(null,"ENDEREÇO COMPLETO:\n\n"+end.getRua()+", "+end.getNumero()+" - "+end.getComplemento()+" - "+end.getBairro()+" - "+end.getCidade()+"/"+end.getEstado()+" - CEP: "+end.getCep());
//					JOptionPane.showMessageDialog(null,"TELEFONE COMPLETO:\n\n"+fone.getDdi()+" ("+fone.getDdd()+") "+fone.getNumero()+" - "+fone.getTipo()+" - "+fone.getOperadora());
//				}
//				
//				if (e.getSource() == bFechar) {
//					dispose();
//					//System.exit(0);  
				}
			}	
		
		//adicionando ouvinte para os botões
		BatSinal batman = new BatSinal();
		btnSalvar.addMouseListener(batman);
		panel.add(btnSalvar);
		
						
		this.repaint();		
	}
}
