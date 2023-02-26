package Queue_y_Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Proyecto_1_Calculadora extends JFrame{

    JLabel labelResultado = new JLabel("Introduzca la expreción algebraica a evaluar");
    JTextField entrada = new JTextField();
    JButton botonResul = new JButton("Evaluar");
    JButton botonNotacion = new JButton("Sacar NP");
    JButton botonBorrar = new JButton("CC");
    String notacionRespuesta;

    Proyecto_1_Calculadora(){


        //  PARTE DE INTERFAZ GRÁFICA

        //Label que muestra el resultado

        labelResultado.setBounds(118,62, 240,40);

        //Codigo que cambia el tamaño de la fuente
        Font FontOriginal = labelResultado.getFont();
        String labelText = labelResultado.getText();

        int stringWidth = labelResultado.getFontMetrics(FontOriginal).stringWidth(labelText);
        int labelWidth = labelResultado.getWidth();
        // Que tanto puede cambiar la fuente segun el width
        double widthRatio = (double)labelWidth / (double)stringWidth;

        int nuevoTamanoFont = (int)(FontOriginal.getSize() * widthRatio);
        int labelHeight = labelResultado.getHeight();

        // Elegir un nuevo tamano de fuente que no sea mas largo que el heigth del label
        int tamanoFont = Math.min(nuevoTamanoFont, labelHeight);

        labelResultado.setFont(new Font(FontOriginal.getName(), Font.PLAIN, tamanoFont));

        add(labelResultado);

        // Text Field entrada

        entrada.setBounds(20, 20, 290, 30);
        /*
        entrada.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                labelResultado.setText("");
            }
        });
         */
        add(entrada);

        //Boton de evaluar

        botonResul.setBounds(20, 70, 40,40);
        botonResul.setFont(new Font(FontOriginal.getName(), Font.BOLD, 10));
        botonResul.setMargin(new Insets(0, 0, 0, 0));
        botonResul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notacionRespuesta != ""){
                    labelResultado.setText(evaluar(notacionRespuesta));
                } else {
                    labelResultado.setText(evaluar(getTokens()));
                }
            }
        });
        add(botonResul);

        //Boton Notación
        botonNotacion.setBounds(70, 70, 40, 40);
        botonNotacion.setFont(new Font(FontOriginal.getName(), Font.BOLD, 10));
        botonNotacion.setMargin(new Insets(0, 0, 0, 0));
        botonNotacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notacionRespuesta = getTokens();
                labelResultado.setText(notacionRespuesta);
            }
        });
        add(botonNotacion);

        //Boton borrar "CC"

        botonBorrar.setBounds(320,21,30,29);
        botonBorrar.setMargin(new Insets(0, 0, 0, 0));
        botonBorrar.setFont(new Font(FontOriginal.getName(), Font.BOLD, 10));
        botonBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { entrada.setText(" "); }
        });
        add(botonBorrar);


        setSize(380, 170);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora de expreciones algebraicas");
        setResizable(false);

    }

    //  PARTE DE NOTACIÓN POSTFIJA
    String getTokens() {
        String items = "";
        String subc = "";
        String expre = entrada.getText();
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

    // Metodo para evaluar la NP
    String evaluar( String NP ){

        return "Q";
    }

    public static void main(String[] args){
        new Proyecto_1_Calculadora();
    }
}
