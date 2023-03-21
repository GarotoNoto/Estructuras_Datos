package Lista_Ligada;

public class Lista_Circular_Clase {
    class Nodo {
        int dato;
        Nodo liga;

        Nodo(int dato) {
            this.dato = dato;
        }
    }
    Nodo front , rear;

    public Lista_Circular_Clase(){
        front = null;
        rear = null;
    }

    public boolean vacia() {
        return front == null;
    }

    public void alta(int dato) {    //Las altas siempre son en el front
        Nodo nvo = new Nodo(dato);
        if(vacia()){
            rear = nvo;
            front = nvo;
        }

        rear.liga = nvo;
        rear = nvo;
    }

    public boolean baja (){
        if (vacia()) return false;
        front = front.liga;
        if(front == null) rear = null;
        return true;
    }

    @Override
    public String toString(){
        String sal = "";
        Nodo ptr = front;
        while(ptr != null){
            sal += ptr.dato + "\t";
            ptr = ptr.liga;
        }
        return sal;
    }

    public static void main (String[] args){
        Lista_Circular_Clase circulo = new Lista_Circular_Clase();
        circulo.alta(5);
        System.out.println(circulo);
    }

}
