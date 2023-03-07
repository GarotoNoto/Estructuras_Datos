package Lista_Ligada;

public class Lista_clase implements Interface{

    class Nodo
    {
        int dato;
        Nodo liga;

        Nodo(int dato)
        {
            this.dato = dato;
            liga = null;
        }
    }

    private Nodo L; //referencia al inicio de la lista ligada
    private int nn; // numero de nodos en la lista ligada

    public Lista_clase()
    {
        L = null; // indica lista ligada vacia
        nn = 0; // la lista ligada vacia contiene 0 nodos
    }

    @Override
    public void altaIni(int ele)
    {
        Nodo nvo = new Nodo(ele); // crea un nuevo nodo
        nvo.liga = L; // señala al dato siguiente
        L = nvo; // se hace que L indique el nodo que acaba de
        nn++; // indica el numero de nodos de la lista ligada

    }

    @Override
    public void altaFin(int ele)
    {

    }

    @Override
    public void altaPos(int ele, int pos)
    {

    }

    @Override
    public boolean bajaIni()
    {
        return false;
    }

    @Override
    public boolean bajaFin()
    {
        return false;
    }

    @Override
    public boolean bajaPos(int pos)
    {
        return false;
    }

    @Override
    public int eleIni()
    {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public int eleFin()
    {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public int elePos(int pos)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public boolean vacia()
    {
        return false;
    }

    @Override
    public String toString()
    {
        Nodo ptr = L; // referencia a un nodo de la lista ligada
        String sal = " ";
        while(ptr != null)
        {
            sal += ptr.dato + ", "; // agrega a sal el dato del
            ptr = ptr.liga; // avanza el siguiente nodo de la lista ligada
        }
        return sal;
    }

}
