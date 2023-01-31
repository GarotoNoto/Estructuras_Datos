<<<<<<< HEAD
=======
public class usaVector() {
  public static void main(String[] args){

    Vector vec = new Vector(1100000);

    for(int i = 0; i < 10; i++){
      vec.altaPos(i, (int)(Math.random()*1000));
    }
    System.out.println(vec);

    vec.heapSort();
    System.out.println("ORDENDADOS: ");
    System.out.println(vec);
  }
}
>>>>>>> 312ef2b96a94544f582c58f84dd7fa92bbc4da0c
