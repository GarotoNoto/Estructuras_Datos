public class usaVector_ejer1 {
    public static void main(String[] args){

        VectorEjerUno vectorP = new VectorEjerUno();

        System.out.println("Se agergan numeros al vector");
        vectorP.altaNum(10);
        vectorP.altaNum(20);
        vectorP.altaNum(45);

        System.out.print("El vector con los numeros agregados: " + vectorP);

        

        System.out.println("El vector queda asi: ");
        System.out.println(vectorP);



    }
}
