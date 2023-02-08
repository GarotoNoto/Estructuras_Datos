
    /* 
     * 1) Para meter (por la derecha, al final)
     * 2) Para sacar 
     * 3) para saber si esta vacio
     * 4) Para que te de el ultimo numero ( de la mas a la dercha )
     */

public class VectorEjerUno {
    
    private int[] vector;
    private int tamanoVector;
    private int numElemVector;  //Es como un pointer que apunta hacia el ultimo numero, es tambien el numero de elementos en el vector
    private boolean bandera = false;

    public VectorEjerUno() {
        numElemVector = 0;
        tamanoVector = 5;
        vector = new int[tamanoVector];
    }

    public VectorEjerUno( int tamanoVector){
        numElemVector = 0;
        this.tamanoVector = tamanoVector;
        vector = new int[tamanoVector];
    }

    public void altaNum(int nuevoNum) {
        // Se comprueba que el vector tenga espacio, sino se le agregan otros diez lugares
        if(this.numElemVector == this.tamanoVector){
            tamanoVector += 10; //Se le da 10 nuevos espacios
            int[] vectorAux = new int[tamanoVector];
            for(int i = 0; i<numElemVector ;i++){
                vectorAux[i] = vector[i];
            }
            vector = vectorAux;  //vector hace referencia a vectorAux
        }

        vector[numElemVector] = nuevoNum;
        numElemVector += 1; //numElemVector++;

    }

    public void bajaNum() {
        vector[numElemVector] = 0;
        numElemVector -= 1; //numElemVector--;
    }


    public boolean saberVacio() {
        if(this.numElemVector == 0){
            System.out.println("El vector esta vacio :(");
            bandera = true;
        } else {
            System.out.println("El vector no esta vacio :)");
            bandera = false;
        }

        /* Otra forma de hacerlo seria comprobar si el primer elemento es 0 nulo o false*/
            /*
        if(this.vector[0] == 0 || this.vector[0] == null){
            System.out.println("El vector esta vacio :(");
            return true;
        }
            */
        return bandera;
    }

    public void ultimoNum() {
        System.out.println("El ultimo numero del vector es: " + vector[numElemVector]);
    }

    @Override
    public String toString(){
        String salida = "";

        for(int i = 0; i<numElemVector; i++){
            System.out.print(vector[i] + " ");
        }

        return salida.toString();
    }

}
