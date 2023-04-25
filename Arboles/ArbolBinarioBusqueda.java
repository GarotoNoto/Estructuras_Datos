package Arboles;

public class ArbolBinarioBusqueda {
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

    public ArbolBinarioBusqueda(){
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

    private void IRD(Nodo actual) {
        if(actual != null){
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

}
