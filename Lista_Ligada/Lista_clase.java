package Lista_Ligada;

public class Lista_clase implements Interface{

    class Nodo
    {
        int dato;
        Nodo liga;

        Nodo(int dato) {
            this.dato = dato;
            liga = null;
        }
    }

    private Nodo apuntador; //referencia al inicio de la lista ligada
    private int numNodos; // numero de nodos en la lista ligada

    public Lista_clase() {
        apuntador = null; // indica lista ligada vacia
        numNodos = 0; // la lista ligada vacia contiene 0 nodos
    }

    @Override
    public void altaIni(int ele) {
        Nodo nvo = new Nodo(ele); // crea un nuevo nodo
        nvo.liga = apuntador; // señala al dato siguiente
        apuntador = nvo; // se hace que apuntador indique el nodo que acaba de
        numNodos++; // indica el numero de nodos de la lista ligada
    }

    @Override
    public void altaFin(int ele) {

    }

    @Override
    public void altaPos(int ele, int pos) {

    }

    @Override
    public boolean bajaIni() {
        return false;
    }

    @Override
    public boolean bajaFin() {
        return false;
    }

    @Override
    public boolean bajaPos(int pos) {
        return false;
    }

    @Override
    public int eleIni() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public int eleFin() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public int elePos(int pos) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public boolean vacia() {
        return false;
    }

    @Override
    public String toString() {
        Nodo lista = apuntador; // referencia a un nodo de la lista ligada
        String sal = " ";
        while(lista != null)
        {
            sal += lista.dato + ", "; // agrega a sal el dato del
            lista = lista.liga; // avanza el siguiente nodo de la lista ligada
        }
        return sal;
    }

    public static void main(String[] args){
        Lista_clase lista = new Lista_clase();
        lista.altaIni(6);
        System.out.println(lista);

        lista.altaIni(9);
        lista.altaIni(4);
        lista.altaIni(1);
        System.out.println(lista);
    }

}
