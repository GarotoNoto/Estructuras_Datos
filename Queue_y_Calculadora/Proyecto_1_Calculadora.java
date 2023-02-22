package Queue_y_Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Proyecto_1_Calculadora extends JFrame{
    //JFrame frame;
    int i = 0;

    Proyecto_1_Calculadora(){
        //Label que muestra el resultado
        JLabel labelResultado = new JLabel("Introduzca la expreción algebraica a evaluar");
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
        JTextField entrada = new JTextField();
        entrada.setBounds(20, 20, 330, 30);
        entrada.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                labelResultado.setText("");
            }
        });
        add(entrada);

        //Boton de signo igual
        JButton botonResul = new JButton("=");
        botonResul.setBounds(20, 70, 80,50);
        botonResul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelResultado.setText("Lo logramos :)");
            }
        });
        add(botonResul);




        setSize(380, 170);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora de expreciones algebraicas");
        setResizable(false);
    }

    public static void main(String[] args){
        new Proyecto_1_Calculadora();
    }
}
