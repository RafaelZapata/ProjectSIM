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
        
        Action cVendasAction = new AbstractAction("Vendas", new ImageIcon("../ProjectSIM/src/images/loja.png"))
        {	private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jCVendas"); }
        };


        Action cClienteAction = new AbstractAction("Cliente", new ImageIcon("../ProjectSIM/src/images/cliente.png"))
        {	private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jCCliente"); }
        };

        Action cAjudaAction = new AbstractAction("Ajuda", new ImageIcon("../ProjectSIM/src/images/ajuda.png"))
        { 	private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jSobre"); }
        };
        
        Action cVendedorAction = new AbstractAction("Vendedor", new ImageIcon("../ProjectSIM/src/images/funcionario.png"))
        {	private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jCFuncionario"); }
        };
        
        Action cProdutoAction = new AbstractAction("Produto", new ImageIcon("../ProjectSIM/src/images/produto.png"))
        {	private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jCProduto"); }
        };

        Action exitAction = new AbstractAction("Sair", new ImageIcon("../ProjectSIM/src/images/sair.png"))
        {	private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jSair"); }
        };

        // Cria os bot�es na Barra de Ferramentas
        ToolButton cVendas  = new ToolButton(cVendasAction);
        ToolButton cCliente  = new ToolButton(cClienteAction);
        ToolButton cVendedor = new ToolButton(cVendedorAction);
        ToolButton cProduto = new ToolButton(cProdutoAction);
        ToolButton cAjuda  = new ToolButton(cAjudaAction);
        ToolButton cExit = new ToolButton(exitAction);

        // Adiciona os bot�es na Barra de Ferramentas
        BFerramenta.add(cVendas);
        BFerramenta.add(cCliente);
        BFerramenta.add(cVendedor);
        BFerramenta.add(cProduto);
        BFerramenta.add(cAjuda);
        BFerramenta.add(cExit);
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