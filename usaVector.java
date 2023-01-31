public class usaVector() {
  public static void main(String[] args){

    Vector vec = new Vector(1000);

    for(int i = 0; i < 1000; i++){
      vec.altaPos(i, (int)(Math.random()*1000));
    }
    System.out.println("Datos desordenados: ");
    System.out.println(vec);

    vec.heapSort();
    System.out.println("Datos ordenados: ");
    System.out.println(vec);
  }
  
}
