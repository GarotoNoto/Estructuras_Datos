package Lista_Ligada;

class LinkedList {
    // Crea un nodo
    Node head;

    static class Node{
        int value;
        Node next;

        Node(int d){
            value = d;
            next = null;
        }
    }

    public void printList(){
        Node n = head;
        while (n != null){
            System.out.print(n.value + " ");
            n = n.next;
        }
    }

    public void pushHead(int value){
        Node newHead = new Node(value);
        head.next = head;
        this.head = newHead;
    }

    public void pushTail(int value){
        Node newTail = new Node(value);
        if(head == null){
            head = newTail;
            return;
        }
        newTail.next = null;
        Node tail = head;
        while(tail.next != null)
            tail = tail.next;
        tail.next = newTail;
    }

    public void push(Node prev_node, int value){
        if(prev_node == null){
            System.out.print("El nodo anterior no puede ser nulo");
            return;
        }
        Node newNode = new Node(value);
        newNode.next = prev_node.next;
        prev_node.next = newNode;
    }

    public void popHead(){
        head = head.next;
    }

    public void popTail(){

    }

    public static void main(String[] args){
        LinkedList ListaLigada = new LinkedList();

        //Asignando valores
        ListaLigada.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        //Conectando Nodos
        ListaLigada.head.next = second;
        second.next = third;


    }
}
