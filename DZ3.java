
//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметичское этого списка.  O(n)
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class DZ3 {
    private static List<Integer> filllist(int size){
        List<Integer> lst = new ArrayList<Integer>(size);
        Random rand = new Random();
        for(int i = 0; i < size; i++)
            lst.add(rand.nextInt(10)); 
        return lst;
       }
    private static double[] sort_of_list(List<Integer> lst){
        double[] result = new double[3];
        result[0] = lst.get(0);
        result[1] = lst.get(0);
        for(int i = 0; i < lst.size(); i++){
            if(result[0]>lst.get(i))result[0] = lst.get(i);
            if(result[1]<lst.get(i))result[1] = lst.get(i);
            result[2] += lst.get(i);
        }
        result[2] /= lst.size();
        return result;

    }
    
       public static void main(String[] args) {
        Scanner Scaner = new Scanner(System.in,"cp866");
        
        int number = 0;
        boolean flag = true;
        while(flag){
            System.out.print("Введите число n > 0: ");
            try
                    {
                        String s = Scaner.next();
                        number  = Integer.parseInt(s.trim());  
                        if(number > 0) flag = false;
    
                    }
            catch (NumberFormatException nfe)
                {
                    System.out.println("Введенные данные не являются натуральным числом" );
                }
            }
        Scaner.close();
        List<Integer> lst = filllist(number);
        System.out.println(lst);
        double [] arr = sort_of_list(lst);
        System.out.printf("максимальное значение %1$.0f Минимальное значение %2$.0f среднее арифметичское %3$.2f",arr[1],arr[0], arr[2]);
       }
}
