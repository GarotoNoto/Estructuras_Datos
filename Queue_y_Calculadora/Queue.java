package Queue_y_Calculadora;

/*
    Es el ejemplo de una cola circular
 */

public class Queue {
    int [] cola; //elementos de la cola
    int numero; // Tamaño
    int front, rear;

    //Constructores
    public Queue (int numero){
        this.numero = numero;
        cola = new int[numero];
        front = 0;
        rear = 0;
    }
    public Queue() { this(4); }

    public boolean vacia() { return front == rear; }
    public boolean llena() { return (front+1) % numero == front; }

    public boolean push (int elemento){
        if(llena())
            return false;
        cola[rear] = elemento;
        rear = (rear+1)%numero;
        return true;
    }

    public boolean pop(){
        if(vacia())
            return false;
        front = (front+1)%numero;
        return true;
    }

    public int peek(){
        return cola[front];
    }
    /*
    @Override
    public String toString(){
        String salida = "";
        int aux
    } */
}
