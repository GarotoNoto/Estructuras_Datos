package Arboles;

//import javax.swing.*;
//import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class proyecto_dos_Arboles {
    class Nodo{
        int dato;
        Nodo hijoIzq, hijoDer;

        public Nodo(int dato){
            this.dato = dato;
            hijoIzq = null;
            hijoDer = null;
        }
    }
    private Nodo raiz;

    public proyecto_dos_Arboles(){
        raiz = null;
    }

    private Nodo alta(Nodo actual, int dato){
        if(actual == null){ //está en la posición del nuevo nodo
            Nodo nvo = new Nodo(dato);
            return nvo;
        }
        if(dato>actual.dato){
            actual.hijoDer = alta(actual.hijoDer, dato);
        } else {
            actual.hijoIzq = alta(actual.hijoIzq, dato);
        }

        return actual;
    }

    public void altaRec(int dato){
        raiz = alta(raiz, dato);
    }

    private void IRD(Nodo actual) {     //La función esta en orden inverso,
        if(actual != null){             //La raiz es el ultimo nodo en imprimirse!
            IRD(actual.hijoIzq);
            System.out.print(actual.dato + "\t");
            IRD(actual.hijoDer);
        }
    }

    private void DRI(Nodo actual, int nTab){
        if(actual != null){
            DRI(actual.hijoDer, nTab+1);
            for(int i=0; i<nTab; i++) {System.out.print("\t");}
            System.out.print(actual.dato + "\n");
            DRI(actual.hijoIzq, nTab+1);
        }
    }

    public void enOrden(){
        IRD(raiz);
        System.out.println();
    }
    public void enOrdenInv(){
        DRI(raiz, 1);
        System.out.println();
    }

    public void enordenn(){
        IRD(raiz);
    }

    private Nodo quita(Nodo bajaObjetivo, Nodo act){
        if(act.hijoDer != null) quita(bajaObjetivo, act.hijoDer);
        else {
            bajaObjetivo.dato = act.dato;
            return act.hijoIzq;
        }
        return act;
    }

    private Nodo bajaRec(int dato, Nodo act){
        if(act == null) /*dato no existe*/ return act;
        if(dato > act.dato) /* nos vamos a la derecha */ act.hijoDer = bajaRec(dato, act.hijoDer);
        else if(dato < act.dato) /* nos vamos a la izquierda */ act.hijoIzq = bajaRec(dato, act.hijoIzq);
        else /* actual se da de baja */ {
            if(act.hijoIzq == null && act.hijoDer == null) /* es una hoja*/ return null;
            else
                if(act.hijoIzq == null)      /*solo hijo derecho*/ return act.hijoDer;
                else if(act.hijoDer == null) /*solo hijo izquierdo*/ return act.hijoIzq;
                else /* baja de nodo con dos hijos */ act.hijoIzq = quita(act, act.hijoIzq);
        }
        return act;
    }

    public void baja(int dato){
        raiz = bajaRec(dato, raiz);
    }


    /* CODIGO DEL PROYECTO */
    public void buscarGen(){      //1. Un recorrido que proporcione los nodos de la generacion solicitada por el usuario

    }

    public void datosDescen(){     //2. Un recorrido que proporcione los datos del ´arbol en orden descendente

    }

    public int profundidad(){       //3. Una funcion que determine la profundidad del ´arbol asumiendo que la raiz tiene una profundidad uno.

        return 1;
    }

    public int totalNodos(){        //4. Una operacion que cuente el total de nodos del arbol.

        return 1;
    }

    public static void main(String[] args){
        String opc;
        String[] opcs = {"Alta", "Baja", "En Orden", "Inverso", "Buscar Generación", "Descenciente", "Profundidad", "Total Nodos", "Fin"};
        proyecto_dos_Arboles abbP = new proyecto_dos_Arboles();
        int dato;
        String datoTxt;

        abbP.altaRec(400);
        abbP.altaRec(200);
        abbP.altaRec(600);
        abbP.altaRec(100);
        abbP.altaRec(300);
        abbP.altaRec(800);
        abbP.altaRec(250);
        abbP.altaRec(350);
        abbP.altaRec(700);
        abbP.altaRec(330);
        abbP.altaRec(320);

        while(true){        //5. incluya un menu para el uso del programa.
            opc = (String) JOptionPane.showInputDialog(null, "Elije una opción", "Menú", JOptionPane.QUESTION_MESSAGE, null, opcs, opcs[8]);
            if(opc.compareTo("Fin") == 0) break;
            if(opc.compareTo("Alta") == 0){
                datoTxt = JOptionPane.showInputDialog(null, "introduce el dato", "Alta", JOptionPane.QUESTION_MESSAGE);
                dato = Integer.parseInt(datoTxt);
                abbP.altaRec(dato);
            }
            if(opc.compareTo("Baja")==0){
                datoTxt = JOptionPane.showInputDialog(null, "introduce el dato", "Baja", JOptionPane.QUESTION_MESSAGE);
                dato = Integer.parseInt(datoTxt);
                abbP.baja(dato);
            }
            if(opc.compareTo("En Orden")==0){
                abbP.enOrden();
            }
            if(opc.equals("Inverso")){
                abbP.enOrdenInv();
            }
            if(opc.equals("Buscar Generación")){
                abbP.buscarGen();
            }
            if(opc.equals("Descenciente")){
                abbP.datosDescen();
            }
            if(opc.equals("Profundidad")){
                int profundidad = abbP.profundidad();
                JOptionPane.showMessageDialog(null, "La profuncidad del arbol es de " + profundidad, "Profundidad", 1);
            }
            if(opc.equals("Total Nodos")){
                int totalNodos = abbP.totalNodos();
                JOptionPane.showMessageDialog(null, "El número total de nodos es de " + totalNodos, "Total Nodos", 1);
            }
        }

    }
}
