package Arboles;

import javax.swing.JOptionPane;

public class proyecto_dos_Arboles {
    int contadorNodos = 0;
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

    private Nodo alta(Nodo actual, int dato){       //Siempre se compara con la raiz y va "bajando"; "Nodo actual" podría llamarse "Nodo nodoAComparar"
        if(actual == null){         //está en la posición del nuevo nodo
            Nodo nvo = new Nodo(dato);
            return nvo;
        }
        if(dato>actual.dato){ //Se compara con la "raiz", y de ahi para abajo
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
    // NO SIRVE
    public String buscarGen(int gen){      //1. Un recorrido que proporcione los nodos de la generacion solicitada por el usuario
        Nodo actual;
        if(gen != 1){
            gen--;
            buscarGen(gen);

        }
        BG(raiz, gen);
        //if(gener == 1) return String.valueOf(raiz.dato);
        return "a";
    }

    public void BG(Nodo actual, int gen){
        if(gen != 1){
            gen--;
            BG(actual.hijoIzq, gen);
            System.out.print(actual.hijoIzq.dato + "\t" + actual.hijoDer.dato);
            return;
        }
    }

    public void descendiente(Nodo actual){     //2. Un recorrido que proporcione los datos del arbol en orden descendente
        if(actual != null){
            descendiente(actual.hijoDer);
            System.out.print(actual.dato + "\t");
            descendiente(actual.hijoIzq);
        }
    }

    public int profundidad(Nodo actual){       //3. Una funcion que determine la profundidad del arbol asumiendo que la raiz tiene una profundidad uno.
        if(actual == null) return 0;
        contadorNodos = Math.max(profundidad(actual.hijoIzq), profundidad(actual.hijoDer)) + 1;
        return contadorNodos;
    }

    /* La fucnión "profundidad" se llama con la raiz como inicio
    * Despues entra en la función "Math.max", que compara dos números y devulve el mayor
    * cada vez que intenta comparar un número tiene que recursar la función "profundidad"
    * recursa hacia la izquierda del arbol hasta encontrar un nodo null
    * cuando encuentra un null regresa 0, y "Math.max" obtiene el primer valor que buscaba
    *
    * Ahora se va a la derecha del nodo y hace lo mismo hasta que obtiene otro null
    * Cuando obtiene los dos null los compara (que sale 0 en esta primera iteración) y le suma 1
    *   (Esto porque es el nodo es una hoja)
    * esto a su vez hace que "Math.max" obtenga su primer valor (el de las a la izquierda)
    *   y procede a obtener el valor de la derecha, recursando hasta encontrarlo
    *
    *   MAPA EN EL QUE SE PUEDE VER LA RECURSIÓN
    *
    *                           A
    *                          / \
    *                         B   C
    *                        / \   \
    *                       D   E   F
    *
    *   A = Math.max(B, C) + 1              // "Math.max" tiene que ir a B primero, y ahi recursa hacia D y E
    *
    *   B = Math.max(D, E) + 1
    *   D = Math.max(0,0) + 1 = 1           // Como D y E son hojas, "Math.max" devulve 0 y le suma 1
    *   E = Math.max(0,0) + 1 = 1
    *   B = 2                               // "Math.max" encuentra los valores de izquierda y derecha, los compara y le suma 1
    *
    *   C = Math.max(0, F) + 1
    *   F = Math.max(0,0) + 1 = 1
    *   C = 2
    *
    *   A = Math.max(B, C) + 1 => Math.max(2, 2) + 1 = 3
    * El arbol, entonces, tiene una profundidad de 3 */

    public int totalNodos(){        //4. Una operacion que cuente el total de nodos del arbol.
        contadorNodos = 0;
        int total = TN(raiz);
        return total;
    }

    public int TN(Nodo actual){
        if(actual != null){
            TN(actual.hijoIzq);
            contadorNodos++;
            TN(actual.hijoDer);
        }
        return contadorNodos;
    }

    public static void main(String[] args){
        String opc;
        String[] opcs = {"Alta", "Baja", "En Orden", "Inverso", "   --------", " - Buscar Generación", " - Descenciente", " - Profundidad", " - Total Nodos", "Fin"};
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

        while(true){                        //5. incluya un menu para el uso del programa.
            opc = (String) JOptionPane.showInputDialog(null, "Elije una opción", "Menú", JOptionPane.QUESTION_MESSAGE, null, opcs, opcs[9]);
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

            /* CODIGO DEL PRYECTO */
            if(opc.equals(" - Buscar Generación")){
                datoTxt = JOptionPane.showInputDialog(null, "Introduce la generación que quieres ver", "Buscar Generación", JOptionPane.QUESTION_MESSAGE);
                dato = Integer.parseInt(datoTxt);
                datoTxt = abbP.buscarGen(dato);
                JOptionPane.showMessageDialog(null, "Los nodos de la generación " + datoTxt + " son: " + datoTxt, "Buscar Generación", 1);
            }
            if(opc.equals(" - Descenciente")){
                abbP.descendiente(abbP.raiz);
                JOptionPane.showMessageDialog(null, "El arbol se imprimió de forma descendente en la consola", "Datos Descendientes", 1);
                System.out.println();
            }
            if(opc.equals(" - Profundidad")){
                int profundidad = abbP.profundidad(abbP.raiz);
                JOptionPane.showMessageDialog(null, "La profundidad del arbol es de " + profundidad, "Profundidad", 1);
            }
            if(opc.equals(" - Total Nodos")){
                int totalNodos = abbP.totalNodos();
                JOptionPane.showMessageDialog(null, "Este arbol tiene un total de " + totalNodos + " nodos", "Total Nodos", 1);
                totalNodos = 0;
            }
        }

    }
}
