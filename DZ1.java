import java.util.Random;

//Реализовать алгоритм сортировки слиянием.

// скорость О(n*log(n))

class DZ1{
    private static int[] fillarray(int size){  // Функция заполняет массив радомно числами от 0 до 99
        int[] array = new int[size];
        Random rand = new Random();
        for(int i = 0; i < size; i++)
            array[i] = rand.nextInt(100);
        return array;
    }
    private static void printarray(int[] array){ // Функция выводит массив на экран
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
    private static int[] mergearray(int[] array1, int[] array2){
        int[] array = new int[array1.length + array2.length];       // выделяем память под общий массив
        int pos1 = 0, pos2 = 0;
        for(int i = 0; i < array.length; i++){
            if(pos1 == array1.length){          // если первый массив исчерпан то работаем со вторым
                array[i] = array2[pos2];
                pos2++;
            }else if(pos2 == array2.length){    // если ворой массив исчерпан то работаем с первым
                array[i] = array1[pos1];
                pos1++; 
            }else if(array1[pos1] < array2[pos2]){ // если pos1й элемент первого массива < pos2ог элемента 2го массива то включаем его в общий массив
                array[i] = array1[pos1];
                pos1++;
            }else{
                array[i] = array2[pos2];
                pos2++;
            }
        }
        return array; // возвращаем общий массив
    }
    private static int[] sortmerge(int[] array) {
        if(array == null) return null;          // Проверка на наличие входных данных
        if(array.length == 1){         // Если длина массива раина 1 то возвращаем его, необходим для выхода из рекурсии
            return array;
        }else{  // Иначе делим пополам и записываем в новые массивы
            int[]  array1 = new int[array.length/2];        // первая половина
            int[]  array2 = new int[array.length - array.length/2];     // вторая половина
            System.arraycopy(array, 0, array1, 0, array.length/2);      // копируем данные первой половины массива
            System.arraycopy(array, array.length/2, array2, 0, array.length - array.length/2);  // копируем данные второй половины массива
            return mergearray(sortmerge(array1),sortmerge(array2)); // рекурсия на разбивание массивов результат сразу отправляем в слияние и возвращаем через return
        }
           
       }
    public static void main(String[] args) {
       int[] array = fillarray(20);
       printarray(array); 
       printarray(sortmerge(array));   
    }
}