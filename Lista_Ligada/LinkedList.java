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

    public static void main(String[] args){
        LinkedList ListaLigada = new LinkedList();

        //Asignando valores
        ListaLigada.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        //Conectando Nodos
        ListaLigada.head.next = second;
        second.next = third;

        //Imprimiendo valores
        while (ListaLigada.head != null){
            System.out.print(ListaLigada.head.value + " ");
            ListaLigada.head = ListaLigada.head.next;
        }
    }
}
