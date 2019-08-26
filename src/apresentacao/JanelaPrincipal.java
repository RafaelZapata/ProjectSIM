package apresentacao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Graphics;


@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame
{
    private JDesktopPane theDesktop;
    private BarradeMenu MenuB;
    private BarradeFerramenta FerramentaB;
    private BarradeStatus StatusB;
    private int screenHeight;
    private int screenWidth;
    private Image wallpaper;

    @SuppressWarnings("deprecation")
	public JanelaPrincipal()
    {   this.setTitle("ProjectSIM");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        screenHeight = (int) Math.round(d.height*0.95);
        screenWidth = (int) Math.round(d.width*0.95);
        this.setSize(screenWidth,screenHeight);
        this.setResizable(false);
        Image img = tk.getImage("../ProjectSIM/src/images/logo.png");
        this.setIconImage(img);
        this.addWindowListener(new WindowAdapter()
        { public void windowClosing(WindowEvent e)
            { System.exit(0); }
        });

        //Imagem fundo
        wallpaper = Toolkit.getDefaultToolkit().createImage("../ProjectSIM/src/images/background6.png");
        JPanel fundo = new NewContentPane();
        
        Container contentPane = getContentPane();
        BorderLayout layout = new BorderLayout(5,5);
        contentPane.setLayout(layout);

        // Barra de Menu
        MenuB = new BarradeMenu();
        MenuB.add(this);
        this.setJMenuBar(MenuB.make());

        //Barra de Ferramenta
        FerramentaB = new BarradeFerramenta();
        FerramentaB.add(this);
        contentPane.add(FerramentaB.make(),BorderLayout.NORTH);

        //Barra de Status
        StatusB = new BarradeStatus();
        contentPane.add(StatusB,BorderLayout.SOUTH);
        
        //Janela Central
        theDesktop = new JDesktopPane();
        theDesktop.setSize(screenWidth, screenHeight);
        super.add(fundo, BorderLayout.CENTER);
        this.show();
        
    }
    
    private class NewContentPane extends JPanel
    {	protected void paintComponent(final Graphics g)
      	{	super.paintComponent(g);
            g.drawImage(wallpaper,-10,-10,screenWidth,(int) (screenHeight*0.85),this);
        }
    }
    

// ********************************
// Inï¿½cio da Definiï¿½ï¿½o dos Métodos
// ********************************

// Método Janela Novo Cliente

    public void jCCliente()
    {  	CadClientView objTCC = new CadClientView();	}

// Método Janela Novo Produto
    public void jCProduto()
    {  CadProdutoView objTCP = new CadProdutoView(); }

// Método Janela Novo Funcionario
    public void jCFuncionario()
    {  CadFuncionarioView objTCF = new CadFuncionarioView(); }

// Método Janela Nova Venda    
    public void jCVendas()
    {  CadVendaView objTCV = new CadVendaView(); }
    
// Método Janela Sobre
   public void jSobre()
   { JOptionPane.showMessageDialog(null,"Instituto Federal Fluminense - IFF Campos (Campus Centro)\nDisciplina de Programação Orientada a Objetos\nAplicação em Java usando Banco de Dados MySQL - versão 1.0\nLayout designed by Professora Giselle Almeida\nCopyright - Todos os direitos reservados\nInformações: diogoasp13@gmail.com/rafaeldzapata@gmail.com","Sobre a APLICATIVO",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("../ProjectSIM/src/images/ajuda.gif")); }


// Método Janela Sair
   public void jSair()
   { this.dispose(); }

}