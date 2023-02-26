package Queue_y_Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

public class GUIExpresion extends JFrame {
    private static final long serialVersionUID = 1L;
    JPanel pp;
    JTextField infija;
    JTextField tokens;
    JButton accion;
    /*
     private String getTokens() {
        String items = "";
        StringTokenizer tokens=new StringTokenizer(infija.getText(), "+-/*_()!", true);
        while (tokens.hasMoreTokens()) items += tokens.nextToken() +", ";
        return items;
     }
    */
    String getTokens() {
        String items = "";
        String subc = "";
        String expre = infija.getText();
        for(int i=0; i<expre.length(); i++ ) {
            if(expre.charAt(i) == '+' ||
                    expre.charAt(i) == '-' ||
                    expre.charAt(i) == '*' ||
                    expre.charAt(i) == '/' ||
                    expre.charAt(i) == '!' ||
                    expre.charAt(i) == '_' ||
                    expre.charAt(i) == '(' ||
                    expre.charAt(i) == ')' ) {
                if(subc.length()>0) items += subc +", ";
                subc = "";
                items += expre.substring(i,i+1) + ",";
            } else subc += expre.substring(i,i+1) ;
        }
        if(subc.length()>0) items += subc +", ";
        return items;
    }

    public GUIExpresion() {
        infija = new JTextField();
        infija.setHorizontalAlignment(JTextField.RIGHT);
        tokens = new JTextField();
        pp = (JPanel)this.getContentPane();
        accion = new JButton("Acción");
        accion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                tokens.setText(getTokens());
            }
        });
        pp.setLayout(new BorderLayout());

        pp.add(infija, BorderLayout.NORTH);
        pp.add(tokens, BorderLayout.CENTER);
        pp.add(accion, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(250, 300);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUIExpresion infi = new GUIExpresion();
                    infi.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
