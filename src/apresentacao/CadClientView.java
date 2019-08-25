package apresentacao;

import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import model.*;

public class CadClientView extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel jLabelCpf, jLabelNome, jLabelDataNascimento, jLabelRua, jLabelTelefone, jLabelNumero, jLabelBairro, jLabelCidade, jLabelEstado, jLabelCpfListar, jLabelIdListar, jLabelNomeListar, jLabelCpfExcluir;
	private JTextField jTextFieldCpf, jTextFieldNome, jTextFieldDataNascimento, jTextFieldRua, jTextFieldTelefone, jTextFieldNumero, jTextFieldBairro, jTextFieldCidade, jTextFieldEstado, jTextFieldCpfListar, jTextFieldIdListar, jTextFieldNomeListar, jTextFieldCpfExcluir;
	private JButton btnSalvar, btnListar, btnFechar, btnLimpar, btnExcluir;
	
	String cpf, nome, telefone, rua, dataNascimento, bairro, cidade, estado;
	int numero, id;
	
	Cliente cliente;
	Endereco endereco;
	
	public CadClientView() {
		this.setTitle("Cliente");
		this.setSize(600,520);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(null);
		
		Container container = getContentPane();
		
		JPanel pIncluir = new JPanel();
		pIncluir.setSize(565,200);
		pIncluir.setLocation(10,10); 
		pIncluir.setBorder(BorderFactory.createTitledBorder(" NOVO CLIENTE "));
		pIncluir.setLayout(null);
		container.add(pIncluir);
		
		JPanel pListar = new JPanel();
		pListar.setSize(565,150);
		pListar.setLocation(10,220); 
		pListar.setBorder(BorderFactory.createTitledBorder(" PESQUISAR "));
		pListar.setLayout(null);
		container.add(pListar);
		
		JPanel pExcluir = new JPanel();
		pExcluir.setSize(565,60);
		pExcluir.setLocation(10,380); 
		pExcluir.setBorder(BorderFactory.createTitledBorder(" REMOVER CLIENTE "));
		pExcluir.setLayout(null);
		container.add(pExcluir);
		
		JPanel panel = new JPanel();
		panel.setSize(90,50);
		panel.setLocation(490,440); 
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
		
		jLabelDataNascimento = new JLabel("Data Nascimento: ");
		jLabelDataNascimento.setSize(110, 20);
		jLabelDataNascimento.setLocation(10, 50);
		
		jTextFieldDataNascimento = new JTextField(50);
		jTextFieldDataNascimento.setSize(80, 20);
		jTextFieldDataNascimento.setLocation(115, 53);
		jTextFieldDataNascimento.setText("dd-mm-aaaa");
		
		pIncluir.add(jLabelDataNascimento);
		pIncluir.add(jTextFieldDataNascimento);
		
		jLabelTelefone = new JLabel("Telefone: ");
		jLabelTelefone.setSize(70, 20);
		jLabelTelefone.setLocation(210, 50);
		
		jTextFieldTelefone = new JTextField(50);
		jTextFieldTelefone.setSize(150, 20);
		jTextFieldTelefone.setLocation(270, 53);
		
		pIncluir.add(jLabelTelefone);
		pIncluir.add(jTextFieldTelefone);
		
		jLabelRua = new JLabel("Rua: ");
		jLabelRua.setSize(40, 20);
		jLabelRua.setLocation(10, 80);
		
		jTextFieldRua = new JTextField(50);
		jTextFieldRua.setSize(250, 20);
		jTextFieldRua.setLocation(45, 83);
		
		pIncluir.add(jLabelRua);
		pIncluir.add(jTextFieldRua);
		
		jLabelNumero = new JLabel("Numero: ");
		jLabelNumero.setSize(60, 20);
		jLabelNumero.setLocation(305, 80);
		
		jTextFieldNumero = new JTextField(50);
		jTextFieldNumero.setSize(45, 20);
		jTextFieldNumero.setLocation(360, 83);
		
		pIncluir.add(jLabelNumero);
		pIncluir.add(jTextFieldNumero);
		
		jLabelBairro = new JLabel("Bairro: ");
		jLabelBairro.setSize(50, 20);
		jLabelBairro.setLocation(10, 110);
		
		jTextFieldBairro = new JTextField(30);
		jTextFieldBairro.setSize(135, 20);
		jTextFieldBairro.setLocation(60, 113);
		
		pIncluir.add(jLabelBairro);
		pIncluir.add( jTextFieldBairro);
		
		jLabelCidade = new JLabel("Cidade: ");
		jLabelCidade.setSize(55, 20);
		jLabelCidade.setLocation(210, 110);
		
		jTextFieldCidade = new JTextField(30);
		jTextFieldCidade.setSize(130, 20);
		jTextFieldCidade.setLocation(260, 113);
		
		pIncluir.add(jLabelCidade);
		pIncluir.add( jTextFieldCidade);
		
		jLabelEstado = new JLabel("Estado: ");
		jLabelEstado.setSize(55, 20);
		jLabelEstado.setLocation(405, 110);
		
		jTextFieldEstado = new JTextField(20);
		jTextFieldEstado.setSize(80, 20);
		jTextFieldEstado.setLocation(455, 113);
		
		pIncluir.add(jLabelEstado);
		pIncluir.add( jTextFieldEstado);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setSize(80, 25);
		btnSalvar.setLocation(370, 150);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setSize(80, 25);
		btnLimpar.setLocation(455, 150);
		
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
		btnListar.setLocation(455, 110);
		
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
					
					//Executar o botao limpar - Mas como não está funcionando, vamos apenas colar o codigo
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
					cliente = new Cliente();
					cpf = jTextFieldCpfListar.getText();
					cliente.setCpf(cpf);
					if(!jTextFieldIdListar.getText().equals("")) {
						id = Integer.parseInt(jTextFieldIdListar.getText());
						cliente.setIdCliente(id);
					}	
					if(!jTextFieldNomeListar.getText().equals("")) {
						nome = jTextFieldNomeListar.getText();
						cliente.setNome(nome);
					}
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
					cpf = jTextFieldCpfExcluir.getText();
					cliente = new Cliente();
					cliente.setCpf(cpf);
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
		pIncluir.add(btnSalvar);		pListar.add(btnListar);
		panel.add(btnFechar);
		pIncluir.add(btnLimpar);
		pExcluir.add(btnExcluir);
		
						
		this.repaint();		
	}
}
