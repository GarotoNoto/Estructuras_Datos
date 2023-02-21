package Queue_y_Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serial;

/*
    Esto es la Notación Polaca (NP)
    Mas o menos transforma un input (el mismo que meterias a una calculadora)
     y lo tranforma a un string que despues se puede "calcular"
 */

public class GUI_Expression extends JFrame{
    @Serial
    private static final long serialVersionUID = 1L;
    JPanel pp;
    JTextField infija;
    JTextField tokens;
    JButton accion;

    String getTokens() {
        String items = "";
        String subc = "";
        String expre = infija.getText();
        for (int i=0; i<expre.length(); i++){
            if(expre.charAt(i) == '+' ||
                    expre.charAt(i) == '-' ||
                    expre.charAt(i) == '*' ||
                    expre.charAt(i) == '/' ||
                    expre.charAt(i) == '_' ||
                    expre.charAt(i) == '(' ||
                    expre.charAt(i) == ')' ) {
                if (subc.length() > 0) items += subc + ", ";
                subc = "";
                items += expre.substring(i,i+1) + ",";
            } else subc += expre.substring(i,i+1);
        }
        if (subc.length() > 0) items += subc + ", ";
        return items;
    }

    public GUI_Expression () {
        infija = new JTextField();
        infija.setHorizontalAlignment(JTextField.RIGHT);
        tokens = new JTextField();
        pp = (JPanel)this.getContentPane();
        accion = new JButton("Accion");

        accion.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent a){
               tokens.setText(getTokens());
           }
        });
        // accion.addActionListener(a -> tokens.setText(getTokens()));
        // mismo codigo con funcion lamba

        pp.setLayout(new BorderLayout());

        pp.add(infija, BorderLayout.NORTH);
        pp.add(tokens, BorderLayout.CENTER);
        pp.add(accion, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(250, 300);
    }
}
