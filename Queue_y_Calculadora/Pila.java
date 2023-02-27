package Queue_y_Calculadora;

/*
    Pila (Stack)
        creado enteramente por mi para el proyecto de DS
        muy similar al Queue ya que me base en eso para crear esta Pila
 */

public class Pila {
    int[] pila;
    int tamano;
    int pointer;

    //Constructor
    public Pila (int tamano){
        pila = new int[tamano];
        this.tamano = tamano;
        pointer = 0;
        pila[0] = Integer.parseInt(null);
    }

    public Pila(){      //Siempre tendrá el tamaño de 6, a menos que se especifique de otra manera
        this(6);
    }

    public boolean vacio() {
        return true;
    }

    public boolean lleno(){
        return false;
    }

    public boolean push (int elemento) {
        if(lleno())
            return false;
        pila[pointer + 1] = elemento;
        return true;
    }

    public boolean pop () {
        if(vacio())
            return false;
        pointer--;
        return true;
    }

    public int peek() {
        return pila[pointer];
    }
}
