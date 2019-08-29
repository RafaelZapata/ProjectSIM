package apresentacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

public class BarradeMenu
{
    Object gui;

    @SuppressWarnings("deprecation")
	public JMenuBar make()
    {           
        JMenuBar BMenu = new JMenuBar();

        // Cria o Menu Gerenciamentos na Barra de Menu
        JMenu menu1 = new JMenu("Cadastros");
        menu1.setMnemonic(KeyEvent.VK_G); // Sublinha a letra C do Menu Cadastros 
        menu1.setFont(new Font ("Arial",Font.PLAIN,12));

        // Op��o do Menu Gerenciamentos 
        JMenuItem menu1Item0 = new JMenuItem("Vendas...",new ImageIcon("../ProjectSIM/src/images/loja.png"));
        menu1Item0.setFont(new Font ("Arial",Font.PLAIN,11));
        menu1Item0.setMnemonic(KeyEvent.VK_A);
        menu1Item0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
        menu1Item0.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jCVendas"); }
        });
        
        // Op��o 1 - Cliente
        JMenuItem menu1Item1 = new JMenuItem("Cliente...",new ImageIcon("../ProjectSIM/src/images/cliente.png"));
        menu1Item1.setFont(new Font ("Arial",Font.PLAIN,11));
        menu1Item1.setMnemonic(KeyEvent.VK_C);
        menu1Item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
        menu1Item1.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jCCliente"); }
        });

        // Op��es do Menu Cadastros
        // Op��o 2 - Vendedor
        JMenuItem menu1Item2 = new JMenuItem("Vendedor...",new ImageIcon("../ProjectSIM/src/images/funcionario.png"));
        menu1Item2.setFont(new Font ("Arial",Font.PLAIN,11));
        menu1Item2.setMnemonic(KeyEvent.VK_V);
        menu1Item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
        menu1Item2.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jCFuncionario"); }
        });
 
        // Op��es do Menu Cadastros B�sicos
        // Op��o 3 - Sair
        JMenuItem menu1Item3 = new JMenuItem("Sair",new ImageIcon("../ProjectSIM/src/images/sair.png"));
        menu1Item3.setFont(new Font ("Arial",Font.PLAIN,11));
        menu1Item3.setMnemonic(KeyEvent.VK_S);
        menu1Item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
        menu1Item3.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jSair"); }
        });

        // Adiciona os itens criados ao Menu Cadastros B�sicos
        menu1.add(menu1Item0); 
        menu1.add(menu1Item1);  // Item Cadastro Cliente
        menu1.add(menu1Item2);  // Item Cadastro Vendedor
        menu1.addSeparator();   // Separador
        menu1.add(menu1Item3); // Item Sair


      // Cria o Menu Ajuda na Barra de Menu      JMenu menu2 = new JMenu("Ajuda");
      menu2.setMnemonic(KeyEvent.VK_U);
      menu2.setFont(new Font ("Arial",Font.PLAIN,11));

      // Op��es do Menu Ajuda
      // Op��es 1 - Sobre
      JMenuItem menu2Item1 = new JMenuItem("Sobre",new ImageIcon("../ProjectSIM/src/images/ajuda.gif"));
      menu2Item1.setFont(new Font ("Arial",Font.PLAIN,11));
      menu2Item1.setMnemonic(KeyEvent.VK_S);
      menu2Item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
      menu2Item1.addActionListener(new ActionListener()
      { public void actionPerformed(ActionEvent e)
        { chamaMetodo(e,"jSobre"); }
      });
     
      // Adiciona os itens criados ao Menu Ajuda
      menu2.add(menu2Item1); // Item Sobre

      // Adiciona os Menus da Barra de Menu
      BMenu.add(menu1); // Cadastros Aqui
      BMenu.add(menu2); // Ajuda

      return BMenu;
    }




//********************************************
//M�todo gen�rico para chamada autom�tica dos
//m�todos vinculados aos itens de menu
//********************************************
    public void add(Object gui)
    { this.gui  = gui; }

    private void chamaMetodo(ActionEvent e, String xMetodo)
    {   Method metodo;
        try{   
        	metodo = gui.getClass().getMethod(xMetodo, null);
            metodo.invoke(gui, null);
        }
        catch (NoSuchMethodException nsme)
        { JOptionPane.showMessageDialog(null, "M�todo n�o definido para este evento/menu - ERR1"); }
        catch (IllegalAccessException iae)
        {JOptionPane.showMessageDialog(null, "M�todo n�o definido para este evento/menu - ERR2"); }
        catch (InvocationTargetException ite)
        {   ite.getTargetException().printStackTrace();
            JOptionPane.showMessageDialog(null, "M�todo n�o definido para este evento/menu - ERR3");
        }
    }
}