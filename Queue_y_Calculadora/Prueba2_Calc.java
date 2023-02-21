package Queue_y_Calculadora;

import javax.swing.*;
import java.awt.event.*;

public class Prueba2_Calc extends JFrame{
    //JFrame frame;
    int i = 0;

    Prueba2_Calc(){
        JTextField entrada = new JTextField();
        entrada.setBounds(20, 20, 250, 40);
        entrada.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                entrada.setText("");
            }
        });
        add(entrada);

        JButton botonResul = new JButton("=");
        botonResul.setBounds(20, 80, 80,50);
        botonResul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
                entrada.setText("Hay " + i + " horas de sufrimiento aquí");
            }
        });
        add(botonResul);

        setSize(300, 200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora");
        setResizable(false);
    }

    public static void main(String[] args){
        new Prueba2_Calc();
    }
}
