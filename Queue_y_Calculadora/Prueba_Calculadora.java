package Queue_y_Calculadora;

import javax.swing.*;

public class Prueba_Calculadora {
    JFrame frame;

    Prueba_Calculadora(){
        frame = new JFrame(); //Crea un JFrame

        JTextField entrada = new JTextField();
        entrada.setBounds(10, 20, 280, 40);
        frame.add(entrada);

        JButton boton1 = new JButton("1");
        JButton boton2 = new JButton("2");
        JButton boton3 = new JButton("3");
        JButton boton4 = new JButton("4");
        JButton boton5 = new JButton("5");
        JButton boton6 = new JButton("6");
        JButton boton7 = new JButton("7");
        JButton boton8 = new JButton("8");
        JButton boton9 = new JButton("9");

        boton1.setBounds(30,200,70, 40);
        boton2.setBounds(110,200,70, 40);
        boton3.setBounds(190,200,70, 40);
        boton4.setBounds(30,250,70, 40);
        boton5.setBounds(110,250,70, 40);
        boton6.setBounds(190,250,70, 40);
        boton7.setBounds(30,300,70, 40);
        boton8.setBounds(110,300,70, 40);
        boton9.setBounds(190,300,70, 40);

        frame.add(boton1);
        frame.add(boton2);
        frame.add(boton3);
        frame.add(boton4);
        frame.add(boton5);
        frame.add(boton6);
        frame.add(boton7);
        frame.add(boton8);
        frame.add(boton9);

        frame.setSize(400,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new Prueba_Calculadora();
    }
}
