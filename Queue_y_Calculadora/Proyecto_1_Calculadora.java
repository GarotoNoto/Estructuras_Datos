package Queue_y_Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Math.round;

public class Proyecto_1_Calculadora extends JFrame{
    Pila pila = new Pila();

    JLabel labelResultado = new JLabel("Introduzca la expreción algebraica a evaluar");
    JTextField entradaTxtF = new JTextField();
    JButton botonResul = new JButton("Evaluar");
    JButton botonNotacion = new JButton("NP");
    JButton botonBorrar = new JButton("CC");
    String notacionRespuesta = "";

    Proyecto_1_Calculadora(){


        //  PARTE DE INTERFAZ GRÁFICA

        //Label que muestra el resultado
        labelResultado.setBounds(127,60, 250,40);

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

        // Text Field entradaTxtF

        entradaTxtF.setBounds(20, 20, 290, 30);
        entradaTxtF.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                notacionRespuesta = "";
                //labelResultado.setText(notacionRespuesta);
            }
        });

        add(entradaTxtF);

        //Boton de evaluar
        botonResul.setBounds(20, 70, 45,40);
        botonResul.setFont(new Font(FontOriginal.getName(), Font.BOLD, 10));
        botonResul.setMargin(new Insets(0, 0, 0, 0));
        botonResul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //obtenerTokens(entradaTxtF.getText());
                //System.out.println(obtenerTokens(entradaTxtF.getText()));

                if (notacionRespuesta.equals("")){      //Si está vacia
                    notacionRespuesta = getTokens();
                    //labelResultado.setText(evaluar(notacionRespuesta));
                    System.out.println(evaluar("37+"));
                } else {                                // Si ya tiene algo
                    //labelResultado.setText(evaluar(getTokens()));
                }
            }
        });
        add(botonResul);

        //Boton Notación
        botonNotacion.setBounds(70, 70, 45, 40);
        botonNotacion.setFont(new Font(FontOriginal.getName(), Font.BOLD, 10));
        botonNotacion.setMargin(new Insets(0, 0, 0, 0));
        botonNotacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notacionRespuesta = getTokens();
                labelResultado.setText(notacionRespuesta);
                System.out.println(notacionRespuesta);
            }
        });
        add(botonNotacion);

        //Boton borrar "CC"

        botonBorrar.setBounds(320,21,30,29);
        botonBorrar.setMargin(new Insets(0, 0, 0, 0));
        botonBorrar.setFont(new Font(FontOriginal.getName(), Font.BOLD, 10));
        botonBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notacionRespuesta = "";
                entradaTxtF.setText(" ");
            }
        });
        add(botonBorrar);


        setSize(380, 170);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora de expreciones algebraicas");
        setResizable(false);
    }

    String obtenerTokens( String exprecion ) {
        exprecion = exprecion.replaceAll("\\s", "");   //Expreción para borar los espacios
        char substraerChar = '\0'; //Busca los char que esten vacios

        return exprecion;
    }

    // TODO: Areglar 'getTockens()' para que de la Notación Postfija

    //  PARTE DE NOTACIÓN POSTFIJA
    String getTokens() {
        String items = "";
        String subc = "";
        String expre = entradaTxtF.getText();
        for(int i=0; i<expre.length(); i++ ) {
            if(expre.charAt(i) == '+' ||
               expre.charAt(i) == '-' ||
               expre.charAt(i) == '*' ||
               expre.charAt(i) == '/' ||
               expre.charAt(i) == '!' || // Menos unitario
               expre.charAt(i) == '_' || // Raiz Cuadrada
               expre.charAt(i) == '^' || // exponente
               //expre.charAt(i) == 'e' || // Func. Seno
               expre.charAt(i) == '(' ||
               expre.charAt(i) == ')'
            ) {
                if(subc.length()>0)
                    items = items + (subc + ", "); //Esta parte solo impide que se ponga una coma al principio (?)
                subc = "";
                items = items + (expre.substring(i, i + 1) + ","); // Aquí se agreaga el operador a la cola
            } else subc = subc + expre.substring(i, i + 1); // Aquí se agreaga el numero a la cola
            // CHECAR QUE ES "SUBC" -> ES "SUBSTRAER CARACTER" !!
        }
        if(subc.length()>0) items = items + (subc + ", ");  //Esta parte es para poner una ',' despues de agregar algo a la cola
        return items;
    }

    /*
        TODO: Investigar como agregar jerrarquia en las operaciones
        TODO: Terminar el 'evaluar()' con al menos los operandos binarios
    */


    // Metodo para evaluar la NP
    String evaluar( String NP ){
        char caracter;
        char op2, op1;
        double r = 0;

        for(int i = 0; i < NP.length(); i++){
            caracter = NP.charAt(i);
            if( Character.isDigit(caracter) ){                        //Si es un número
                pila.push(caracter);
            } else if (caracter == '!' || caracter == '¬') {          // Si es operador unario
                op2 = pila.peek();
                pila.pop();
            } else {                                                  // Si es operador binario
                op2 = pila.peek();
                pila.pop();
                op1 = pila.peek();

                r = r + Double.parseDouble(String.valueOf(op2)) + Double.parseDouble(String.valueOf(op1));
                r = Math.round(r*100)/100.0;  //Para redondear a dos decimales
                caracter = (char) r;
                System.out.println(caracter);
                pila.push(caracter);

            } // Fin else

        } // Fin for
        return NP;
        //TODO comvertir de double a string y de string a char

    }

    public static void main(String[] args){
        new Proyecto_1_Calculadora();
    }
}
