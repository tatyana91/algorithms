import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {        
        MyArray arr = new MyArray();
        int[] ex = new int[]{1, 2, 3, 4, 5};
        int[] ex1 = arr.addToStart(ex, -1);
        System.out.println(Arrays.toString(ex1));
        int[] ex2 = arr.addToEnd(ex, -1);
        System.out.println(Arrays.toString(ex2));        
    }
}
