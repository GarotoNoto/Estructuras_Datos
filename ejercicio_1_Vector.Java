
    /* 
     * 1) Para meter (por la derecha, al final)
     * 2) Para sacar 
     * 3) para saber si esta vacio
     * 4) Para que te de el ultimo numero ( de la mas a la dercha )
     */

public class ejercicio_1_Vector {

    private int[] vector;
    private int tamanoVector;
    private int numElemVector;

    public ejercicio_1_Vector () {
        numElemVector = 0;
        tamanoVector = 4;
        vector = new int[tamanoVector];
    }

    public ejercicio_1_Vector ( int tamanoVector){
        numElemVector = 0;
        this.tamanoVector = tamanoVector;
        vector = new int[tamanoVector];
    }

    private void heap (int L, int r, int[] vectorHeap){ // r la posición mas para abajo, el ultimo
        int i = L;
        int j = 2*i;
        int dato = vectorHeap[i]; // dato a ubicar

        while(j <= r){
            if(j<r && vectorHeap[j] > vectorHeap[j+1])
                j++; //Toma el valor de la derecha
            if(dato > vectorHeap[j])
                vectorHeap[i] = vectorHeap[j];
            else break;
            i = j;  //desciende
            j = 2*i; //desciende
        }

        vectorHeap[i] = dato;
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

        

    }

    public void bajaNum() {



    }


    public boolean saberVacio() {
        if(this.numElemVector == 0){
            System.out.println("El vector esta vacio :(");
            return true;
        } else if (this.numElemVector > 0) {
            System.out.println("El vector ya tiene elementos :)");
            return false;
        }

        /* Otra forma de hacerlo seria comprobar si el primer elemento es 0 nulo o false*/
            /*
        if(this.vector[0] == 0 || this.vector[0] == null){
            System.out.println("El vector esta vacio :(");
            return true;
        }
            */
    }

    public ultimoNum() {



    }

}