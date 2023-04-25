package Lista_Ligada;

import javax.swing.JOptionPane;

public class Recursividad {
    static long fac(int n){
        if(n==0) return 1;
        return n*fac(n-1);
    }

    static long fib(int n){
        if (n==1 || n == 2)return 1;
        return fib(n-1)+fib(n-2);
    }

    static int[] crea(int n){
        int[] v = new int[n];
        for(int i = 0; i <n;i++)
            v[i] = (int)Math.random()*1000+1;
        return v;
    }

    static String muestra(int[] v){
        String sal = "";
        for(int i = 0; i<v.length; i++)
            sal += v[i] + "\t";
        return sal;
    }

    static void quickSort(int[] v){

    }

    public static void main(String[] args){
        String opc;
        String[] opcs = {"factorial", "fibonacci", "quickSort", "fin"};
        int dato;
        String datoTxt;
        int[] v;

        while(true){
            opc = (String)JOptionPane.showInputDialog(null, "Elige una opción", "Menu", JOptionPane.QUESTION_MESSAGE, null, opcs, opcs[3]);

            if(opc.compareTo("fin")==0) break;

            if(opc.compareTo("factorial")==0){
                datoTxt = JOptionPane.showInputDialog(null, "introduce el dato", "factorial", JOptionPane.QUESTION_MESSAGE);
                dato = Integer.parseInt(datoTxt);
                JOptionPane.showMessageDialog(null, dato + "! = " +fac(dato), "factorial", JOptionPane.INFORMATION_MESSAGE);
            }
            if(opc.compareTo("fibonacci")==0){
                datoTxt = JOptionPane.showInputDialog(null, "introduce el dato", "Fibonacci", JOptionPane.INFORMATION_MESSAGE);
                dato = Integer.parseInt(datoTxt);
                JOptionPane.showMessageDialog(null, "fib(" + dato + ")= " + fib(dato), "Fibonacci", JOptionPane.INFORMATION_MESSAGE);
            }
            if(opc.compareTo("quickSort")==0){
                datoTxt = JOptionPane.showInputDialog(null, "Número de datos", "Quick Sort", JOptionPane.QUESTION_MESSAGE);
                dato = Integer.parseInt(datoTxt);
                v = crea(dato);
                System.out.print("Datos Desordenados");
                muestra(v);
                quickSort(v);
                System.out.println("Datos ORDENADOS");
                muestra(v);
                //JOptionPane.showMessageDialog(null, muestra(v), "Quick Sort", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
