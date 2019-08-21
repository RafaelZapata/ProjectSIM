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

    public JanelaPrincipal()
    {   this.setTitle("ProjectSIM");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        screenHeight = d.height;
        screenWidth = d.width;
        this.setSize(screenWidth,screenHeight);
        this.setResizable(false);
        Image img = tk.getImage("../ProjectSIM/src/images/executar.gif");
        this.setIconImage(img);
        this.addWindowListener(new WindowAdapter()
        { public void windowClosing(WindowEvent e)
            { System.exit(0); }
        });

      //Imagem fundo
        wallpaper = Toolkit.getDefaultToolkit().createImage("C:\\Users\\diogo_s9uisnc\\Documents\\GitHub\\ProjectSIM\\SIM\\src\\images\\wallPaper0.png");
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
        theDesktop.setSize(screenWidth/3,screenHeight);
        super.add(fundo, BorderLayout.CENTER);
        this.show();
        
    }
    
    private class NewContentPane extends JPanel
    {	protected void paintComponent(final Graphics g)
      	{	super.paintComponent(g);
            g.drawImage(wallpaper,0,0,screenWidth,screenHeight,this);
        }
    }
    

// ********************************
// In�cio da Defini��o dos M�todos
// ********************************

// M�todo Janela Novo Cliente

    public void jCCliente()
    {  	CadClientView objTCC = new CadClientView();	}

// M�todo Janela Novo Produto
    public void jCProduto()
    {   }

// M�todo Janela Novo Funcionario
    public void jCFuncionario()
    {   }

// M�todo Janela Nova Venda    
    public void jCVendas()
    {   }
    
// M�todo Janela Sobre
   public void jSobre()
   { JOptionPane.showMessageDialog(null,"Instituto Federal Fluminense - IFF Campos (Campus Centro)\nDisciplina de Programa�ao Orientada a Objetos\nAplica��o em Java usando Banco de Dados - vers�o 1.0\nCopyright - Todos os direitos reservados\nInforma��es: galmeida@iff.edu.br","Sobre a APLICA��O",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("../ProjectSIM/src/images/ajuda.gif")); }


// M�todo Janela Sair
   public void jSair()
   { this.dispose(); }

}