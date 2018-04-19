package HHTest;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Можно было бы решить задачу проще...
        //Но надо же мне показать мою, пусть и небольшую, но квалификацию?
        //В принципе, основная часть задачи лежитв классе Part в виде функции getMaxIndex,
        //которая принимает массив целых чисел и возвращает его.
        //Код ниже - красивая облицовочка для этого
        int[] InputArray;
            try {
                //Предположим, что массив чисел огромен
                //Значит он, скорее всего, лежит в файле
                File InputFile = new File("./", "Array.txt");
                Scanner fs = new Scanner(InputFile);
                //Будем считать, что массив чисел хранится в файле в одной строке с неопределёнными разделителями
                String RawInputString = fs.nextLine();
                fs.close();
                //Разбиваем с запасом разделительных символов.
                //Ну а мало ли
                String[] RawInputArray = RawInputString.split("[\\s,.:\\-|;]++");
                InputArray = new int[RawInputArray.length];
                for (int i = 0; i < RawInputArray.length; i++)
                    InputArray[i] = Integer.parseInt(RawInputArray[i]);
            } catch (IOException e) {
                //Видимо, файла нет.
                //Ничего страшного, сделаем массив рандомом
                Random gen = new Random();
                InputArray = new int[gen.nextInt(100)];
                for (int i=0;i<InputArray.length;i++)
                    InputArray[i] = gen.nextInt();
            }
        //Чисел много, времени мало.
        //Применим многопоточность
        int MaxIndex = Part.getMaxIndex(InputArray);
        System.out.println("Максимальное значение массива:"+InputArray[MaxIndex]+" по индексу "+MaxIndex);
    }
}
