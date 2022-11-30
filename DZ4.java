// Даны два ArrayList из целых чисел. Написать функции, которые вычисляют разницу коллекций:

// Разность:
// A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
// B - A = все числа из второй коллекции, которые не содержатся в первой

// Симметрическая разность:
// A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DZ4 {
    private static List<Integer> filllist(int size){
        List<Integer> lst = new ArrayList<Integer>(size);
        Random rand = new Random();
        for(int i = 0; i < size; i++)
            lst.add(rand.nextInt(20)); 
        return lst;
       }
       private static List<Integer> raznostL1L2(List<Integer> lst1, List<Integer> lst2){
        List<Integer> lst = new ArrayList<Integer>(lst1.size());
        lst.addAll(lst1);
        lst.removeAll(lst2);
        return lst;
       }
       public static void main(String[] args) {
        List<Integer> lst1 = filllist(5);
        List<Integer> lst2 = filllist(5);
        System.out.print(" Первый лист : ");
        System.out.println(lst1);
        System.out.print(" Второй лист : ");
        System.out.println(lst2);
        System.out.print("Все числа из первой коллекции, которые не содержатся во второй коллекции : ");
        System.out.println(raznostL1L2(lst1,lst2));
        System.out.print("Все числа из второй коллекции, которые не содержатся в первой : ");
        System.out.println(raznostL1L2(lst2,lst1));
        System.out.print("числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой : ");
        List<Integer> lst = raznostL1L2(lst1,lst2);
        lst.addAll(raznostL1L2(lst2,lst1));
        System.out.println(lst);
       } 
}
