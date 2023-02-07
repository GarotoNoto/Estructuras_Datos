
    /* 
     * 1) Para meter (por la derecha, al final)
     * 2) Para sacar 
     * 3) para saber si est vacio
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

    


}