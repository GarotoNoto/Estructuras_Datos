package Queue_y_Calculadora;

/*
    Es el ejemplo de una cola circular

    EN Java hay un Queue ya establecido de base
        Queue<String> cola = new LinkedList<>()
    Se implementa en LinkedList y otros
 */

public class Queue {
    int [] cola; //elementos de la cola
    int numero; // Tamaño
    int head, tail;

    //Constructores
    public Queue (int numero){
        this.numero = numero;
        cola = new int[numero];
        head = 0;
        tail = 0;
    }
    public Queue() { this(4); }

    public boolean vacia() { return head == tail; }
    public boolean llena() { return (head+1) % numero == head; }

    public boolean push (int elemento){
        if(llena())
            return false;
        cola[tail] = elemento;
        tail = (tail+1)%numero;
        return true;
    }

    public boolean pop(){
        if(vacia())
            return false;
        head = (head+1)%numero;
        return true;
    }

    public int peek(){
        return cola[head];
    }
    /*
    @Override
    public String toString(){
        String salida = "";
        int aux
    } */
}
