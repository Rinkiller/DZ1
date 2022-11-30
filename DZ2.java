//Пусть дан произвольный список целых чисел. Удалить из него чётные числа.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DZ2 {
   private static List<Integer> filllist(int size){
    List<Integer> lst = new ArrayList<Integer>(size);
    Random rand = new Random();
    for(int i = 0; i < size; i++)
        lst.add(rand.nextInt(100)); 
    return lst;
   }
   private static List<Integer> remov_even_number(List<Integer> lst){
    
    for(int i = 0; i < lst.size(); i++)
        if(lst.get(i) % 2 == 0){lst.remove(i); i--;} 
        
    return lst;
   }
   public static void main(String[] args) {
    List lst = filllist(10);
    System.out.println(lst);
    System.out.println(remov_even_number(lst));
   }
    
}
