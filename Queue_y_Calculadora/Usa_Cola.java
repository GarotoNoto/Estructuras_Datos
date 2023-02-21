package Queue_y_Calculadora;

public class Usa_Cola {
    public static void main(String[] args){
        Queue cola = new Queue();
        cola.push(8);
        if(!cola.vacia()) System.out.println("Enfrente: " + cola.peek());
        else System.out.println ("VACIO");

        cola.push(7);
        if(!cola.vacia()) System.out.println("Enfrente: " + cola.peek());
        else System.out.println ("VACIO");

        cola.pop();
        if(!cola.vacia()) System.out.println("Enfrente: " + cola.peek());
        else System.out.println ("VACIO");

        cola.push(5);
        if(!cola.vacia()) System.out.println("Enfrente: " + cola.peek());
        else System.out.println ("VACIO");

        cola.pop();
        if(!cola.vacia()) System.out.println("Enfrente: " + cola.peek());
        else System.out.println ("VACIO");

        cola.push(4);
        if(!cola.vacia()) System.out.println("Enfrente: " + cola.peek());
        else System.out.println ("VACIO");

        //for( int i = 0; i <= cola.numero; i++)
        //    System.out.println(" " + cola.cola[i]);
    }
}
