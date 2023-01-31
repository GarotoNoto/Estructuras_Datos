
public class Vector {
    
    private int[] vector; //Datos de la EDA
    private int tamanoVect; 
    private int numElemVector;
    
    //Constructor por defecto
        //Crea tu primer vector (array dinamico)
    public Vector() {
        numElemVector = 0;
        tamanoVect = 4; //Capacidad del vector
        vector = new int[tamanoVect];
    }

    public Vector(int tamanoVect){
        numElemVector = 0; //No hay elementos
        this.tamanoVect = tamanoVect; //Capacidad del vector
        vector = new int[tamanoVect];
    }


    public Vector(Vector origen) { //Cuando se crea un vector sí es para copiar
        this.tamanoVect = origen.tamanoVect;
        this.numElemVector = origen.numElemVector;
        this.vector = new int[tamanoVect];

        for (int i=0; i<n; i++)
            this.vector[i] = origen.vector[i];
    }
    
    public int getTamano(){ return tamanoVect; }
    
    //Se verifica que este vacio el vector
    public int getElem(int pos) { return vector[pos]; }
    public boolean vacio() { return numElemVector == 0; }
    
    public int getNumElem(){ return numElemVector; }
    
    /*
    public boolean estaLLeno(){
        if (this.numElemVector == this.tamanoVect){ //Si ya no hay capacidad, si el vector esta lleno
            tamanoVect += 10;
            int[] w = new int[tamanoVect]; // Nuevo vector con mas capacidad (10 mas)
            for (int i = 0; i<numElemVector; i++) // se copia v en w
                w[i] = vector[i]; 
            vector = w; //v hace referencia a w
        }
        
        return true;
    }
    */
    public boolean altaPos(int posicion, int elemento) {
        if (this.numElemVector == this.tamanoVect){ //Si ya no hay capacidad, si el vector esta lleno
            tamanoVect += 10;
            int[] w = new int[tamanoVect]; // Nuevo vector con mas capacidad (10 mas)
            for (int i = 0; i<numElemVector; i++) // se copia v en w
                w[i] = vector[i]; 
            vector = w; //v hace referencia a w
        }
        
        if(posicion<0) 
            posicion = 0;
        if (posicion>numElemVector)
            posicion = numElemVector;
        
        /*Mueve todos los elementos desde donde seleccionaste (posicion)
            un lugar a la "derecha", osea que el elemento que quieras (elemento)
            se queda en la posicion y todos los demas elementos 
            se mueven un espacio a la "derecha"
            (Imaguina un array, uno por uno los elementos se van
              borando de su lugar y se copian una posicion a la derecha)
        */
        for(int i = numElemVector; i > posicion; i--){
            vector[numElemVector] = elemento; // Se agrega el nuevo elemento a la E.D.
            numElemVector++; // Se cuenta el nuevo elemento
        }
        
        return true;  //Se puede quitar
    }
    
    //Programar las alta al principio, alta al final (cola) , baja al inicio, baja al final
    
    public boolean bajaPos (int posicion) {
        if (posicion < 0)
            return false;
        for(int i = posicion; i < numElemVector - 1; i++)
            vector[i] = v[i+1];
        numElemVector--;
        return true;
    }
    

    private void heap (int L, int r, int[] w){ // r la posición mas para abajo, el ultimo
        int i = L;
        int j = 2*i;
        int dato = w[i]; // dato a ubicar

        do {
            if(j<r && w[j] > w[j+1])
                j++; //Toma el valor de la derecha
            if(dato > vector[j])
                vector[i] = v[j];
            else break;

            i = j;  // desciende
            j = 2*i; // desciende
        } while(j <= r);

        vector[i] = dato;
    }

    public void heapSort() {
        int[] vectorHeap = new int[numElemVector+1];
        for(int i = 0; i<numElemVector; i++)
            vectorHeap[i+1] = vector[i];    //copia vector a vectorHeap con despazamiento

        for(int i = n/2; i>0; i--)
            heap(i, numElemVector, vectorHeap); //Se crea el monton

        int right = numElemVector;
        for( int i = n-1; i > 1; i--){
            int aux = vector[right];
            vector[right] = vector[1];
            vector[1] = aux;
            right--;
            heap(1, right, vectorHeap);
        }

        for(int i = 0; i<n; i++)
            vector[i] = vectorHeap[i+1]; // copia vectorHeap a vector con desplazamiento de 
    }
    
    // puedes agregar un if para eliminar la ultima ","
    @Override
    public String toString(){
        String salida = "Dato = ";
        for(int i = 0;  i < numElemVector; i++) 
            salida += vector[i] + ", ";
        return salida;
    }
    
}
