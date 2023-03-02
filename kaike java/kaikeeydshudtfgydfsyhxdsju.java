// figura 14.15: Button.java
// Criando JButtons.
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame
{
    private JButton plainJButton ; // botão apenas com texto 
    private JButton fancyJButton ; // botão com icones 
    
    // ButtonFrame adiciona JButtons ao Jframe
    public ButtonFrame()  
    {
        super(" testing Buttons");
        setLayout( new FlowLayout () );//configura o layout de frame 
        
        plainJButton = new JButton("plain button "); // botão com texto 
        add( plainJButton );// adiciona plainJButton ao JFrame 
        
        Icon bug1 = new ImageIcon(getClass().getResource("bug1.gif"));
        Icon bug2 = new ImageIcon(getClass().getResource("bug2.gif"));
        fancyJButton = new JButton( "fancy Button",bug1); // configura imagem 
        fancyJButton.setRolloverIcon( bug2 );// configura imagem de rollover
        add( fancyJButton );// adiciona fancyJButton ao JFrame 
        
        // cria novo ButonHandler para tratamento de evento de botão
       ButtonHandler handler = new ButtonHandler();
       fancyJButton.addActionListener( handler);
       plainJButton.addActionListener( handler );
       } // fim do construtor ButtonFrame 
    
    // classe interna para tratamento de evento de botão
    private class ButtonHandler implements ActionListener 
    {
        // trata evento de botão 
        public void actionPerformed( ActionEvent event )
        {
           JOptionPane.showMessageDialog(ButtonFrame.this,String.format(
           "You pressed: %s",event.getActionCommand()));
        } //fim do método actionPerformed
    }// fim da classe Buttonhandler private interna 
} // fim da classe ButtonFrame 
           