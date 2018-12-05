package sample;
import java.util.Arrays;
import java.util.Random;

public class ArrayCreator {
    private int length_arr;
    private int [] arrX;
    private int [] arrFunc;

    ArrayCreator(int len)
    {
        length_arr = len;
        if(len<0) {
            throw new MyException();
        }
        arrX = new int [length_arr];
        arrFunc = new int [length_arr];
    }
    public int[] getArrX() {
        return arrX;
    }

    public int[] getArrFunc() {
        return arrFunc;
    }

    public int getLength_arr() {
        return length_arr;
    }

    public void generatingArray()
    {
        for(int j=0; j <length_arr; j ++) {
            arrX[j] = new Random().nextInt(20);
            arrFunc[j] = 4*arrX[j];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arrX)+"\n"+Arrays.toString(arrFunc);
    }
}
