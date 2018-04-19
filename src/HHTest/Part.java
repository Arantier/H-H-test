package HHTest;

import java.lang.annotation.Target;

public class Part implements Runnable {
    Thread t;
    private int[] TargetArray;
    private int begin;
    private int end;
    private int MaxIndex;
    public void run(){
        for (int i=begin;i<end;i++)
            if (TargetArray[i]>TargetArray[MaxIndex])
                MaxIndex=i;
    }

    private Part(int[] TargetArray,int begin, int end){
        this.TargetArray =  TargetArray;
        this.MaxIndex = this.begin = begin;
        this.end = end;
        t = new Thread(this,"Search from "+begin+" element to "+end+" element");
        t.start();
//        System.out.println(t.getName()+" has begun");
    }

    public static int getMaxIndex(int[] TargetArray){
        //Исходим из того, что 4 потоков нам достаточно
        int Offset = TargetArray.length/4;
        Part First = new Part(TargetArray,0,Offset);
        Part Second = new Part(TargetArray,Offset,Offset*2);
        Part Third = new Part(TargetArray,Offset*2,Offset*3);
        //Остаточек будет немного-больше остальных в случае неделимости размера на 4
        Part Fourth = new Part(TargetArray,Offset*3,TargetArray.length);
        int FirstMaxIndex,SecondMaxIndex;
        if (TargetArray[First.MaxIndex]>TargetArray[Second.MaxIndex])
            FirstMaxIndex = First.MaxIndex;
        else
            FirstMaxIndex = Second.MaxIndex;
        if (TargetArray[Third.MaxIndex]>TargetArray[Fourth.MaxIndex])
            SecondMaxIndex = Third.MaxIndex;
        else
            SecondMaxIndex = Fourth.MaxIndex;
        return (TargetArray[FirstMaxIndex]>TargetArray[SecondMaxIndex]) ? FirstMaxIndex : SecondMaxIndex;
    }
}
