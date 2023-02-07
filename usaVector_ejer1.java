public class usaVector_ejer1 {
    public static void main(String[] args){

        VectorEjerUno vectorP = new VectorEjerUno();

        System.out.print("¿Esta el vector vacio? ");
        vectorP.saberVacio();

        System.out.println("\n Se agergan numeros al vector");
        vectorP.altaNum(10);
        vectorP.altaNum(20);
        vectorP.altaNum(45);
        vectorP.altaNum(90);
        System.out.print("El vector con los numeros agregados: ");
        System.out.println(vectorP);

        System.out.println("\n Se eliminan los dos numeros de la derecha");
        vectorP.bajaNum();
        vectorP.bajaNum();
        System.out.print("\n El vector sin los dos numeros: ");
        System.out.println(vectorP);

        System.out.print("¿Esta el vector vacio? ");
        vectorP.saberVacio();

        vectorP.ultimoNum();


        System.out.print("\n El vector queda asi: ");
        System.out.println(vectorP);
    }
}
