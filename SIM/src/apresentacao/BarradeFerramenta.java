package apresentacao;

import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

public class BarradeFerramenta
{   
	Object gui;

    public JToolBar make()
    {   JToolBar BFerramenta = new JToolBar();
        BFerramenta.setFloatable(true);

        Action botao1Action = new AbstractAction("Cliente", new ImageIcon("../Agenda/src/images/cliente.gif"))
        {	private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jCCliente"); }
        };

        Action botao2Action = new AbstractAction("Ajuda", new ImageIcon("../Agenda/src/images/ajuda.gif"))
        { 	private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jSobre"); }
        };

        Action exitAction = new AbstractAction("Sair", new ImageIcon("../Agenda/src/images/sair.gif"))
        {	private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jSair"); }
        };

        // Cria os bot�es na Barra de Ferramentas
        ToolButton botao1  = new ToolButton(botao1Action);
        ToolButton botao2  = new ToolButton(botao2Action);
        ToolButton botao3 = new ToolButton(exitAction);

        // Adiciona os bot�es na Barra de Ferramentas
        BFerramenta.add(botao1);
        BFerramenta.add(botao2);
        BFerramenta.add(botao3);
        //contentPane.add(BFerramenta,"North");

        return BFerramenta;
}


//********************************************
//M�todo gen�rico para chamada autom�tica dos
//m�todos vinculados aos itens de menu
//********************************************

    public void add(Object gui)
    { this.gui = gui; }

    private void chamaMetodo(ActionEvent e, String xMetodo)
    {   Method metodo;
        try
        {   metodo = gui.getClass().getMethod(xMetodo,null);
        	//Object t = null;
            metodo.invoke(gui,null);
        }
        catch (NoSuchMethodException nsme)
        { JOptionPane.showMessageDialog(null, "Metodo n�o definido para este evento/menu - ERR1"); }
        catch (IllegalAccessException iae)
        { JOptionPane.showMessageDialog(null, "Metodo n�o definido para este evento/menu2 - ERR2"); }
        catch (InvocationTargetException ite)
        {   ite.getTargetException().printStackTrace();
            JOptionPane.showMessageDialog(null, "Metodo n�o definido para este evento/menu - ERR3");
        }
  }
}