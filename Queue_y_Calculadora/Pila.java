package Queue_y_Calculadora;

/*
    Pila (Stack)
        creado enteramente por mi para el proyecto de DS
        muy similar al Queue ya que me base en eso para crear esta Pila
 */

public class Pila {
    String[] pila;
    int tamano;
    int apuntador;

    //Constructor
    public Pila (int tamano){
        pila = new String[tamano];
        this.tamano = tamano;
        apuntador = 0;
        pila[0] = null;
    }

    public Pila(){      //Siempre tendrá el tamaño de 6, a menos que se especifique de otra manera
        this(6);
    }

    public boolean vacia() {
        System.out.println("La pila está vacia");
        return true;
    }

    public boolean llena(){
        System.out.println("La pila está llena");
        return apuntador == (tamano-1);

        //Mismo codigo pero largo
        /*
        if(apuntador == tamano)
            return true;
        return false;
        */
    }

    public boolean push (String elemento) {
        if(llena())
            return false;
        pila[apuntador + 1] = elemento;
        this.apuntador++;
        return true;
    }

    public boolean pop () {
//        if(vacia())
//            return false;
        this.apuntador--;
        return true;
    }

    public String peek() {
        return pila[apuntador];
    }

    public static void main(String[] args){
        Pila pilaPrueba = new Pila();

        pilaPrueba.push("a");
        pilaPrueba.push("b");
        pilaPrueba.push("c");

        pilaPrueba.pop();
        pilaPrueba.pop();

        pilaPrueba.push("d");
        pilaPrueba.push("e");
        pilaPrueba.push("f");
        pilaPrueba.push("g");
        pilaPrueba.push("h");
    }
}
