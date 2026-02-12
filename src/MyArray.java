import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class MyArray {
    //O(N) | O(N)
    public int[] addToStart(int[] arr, int n){
        int[] newArr = new int[arr.length + 1];
        newArr[0] = n;
        for (int i = 0; i < arr.length; i++){
            newArr[i+1] = arr[i];
        }
        return newArr;
    }

    //O(N) | O(N)
    public int[] addToEnd(int[] arr, int n){
        int[] newArr = new int[arr.length + 1];        
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        newArr[newArr.length - 1] = n;
        return newArr;
    }

    //O(N) | O(N)
    public int[] addMiddle(int[] arr, int index, int n) throws Exception {
        if (index < 0 || index > arr.length-1) {
            throw new Exception();
        }
        int[] newArr = new int[arr.length + 1];
        
        for (int i = 0; i < arr.length; i++){
            if (i < index) newArr[i] = arr[i];
            else if (i == index) newArr[i] = n;
            else if (i > index) newArr[i] = arr[i-1];
        }

        return newArr;
    }

    //O(N) | O(N)
    public int[] removeFirst(int[] arr) throws Exception {
        if (arr.length == 0) {
            throw new Exception();
        }
        int[] newArr = new int[arr.length - 1];
        
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i+1];
        }

        return newArr;
    }

    //O(N) | O(N)
    public int[] removeLast(int[] arr) throws Exception {
        if (arr.length == 0) {
            throw new Exception();
        }
        int[] newArr = new int[arr.length - 1];
        
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }

        return newArr;
    }

    //O(N) | O(N)
    public int[] remove(int[] arr, int index) throws Exception {
        if (arr.length == 0 || index < 0 || index > arr.length) {
            throw new Exception();
        }
        int[] newArr = new int[arr.length - 1];
        
        for (int i = 0; i < arr.length; i++){
            if (i < index) newArr[i] = arr[i];
            else if (i > index) newArr[i-1] = arr[i];
        }

        return newArr;
    }

    //O(N) | O(1)
    public int search(int[] arr, int n){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == n) return i;
        }
        return -1;
    }

    //O(N) | O(1)
    public int removeAllN(int[] arr, int n){
        int L = 0;
        for (int R = 0; R < arr.length; R++){
            int val = arr[R];
            if (val == n) continue;
            arr[L] = val;
            L++;
        }
        return L;
    }

    //O(N) | O(1)
    public int remove3Plus(int[] arr){
        if (arr.length == 1) return 1;
        int L = 0;
        for (int R = 2; R < arr.length; R++){
            int val = arr[R];
            if (arr[L-1] == val) continue;
            arr[L+1] = val;
            L++;
        }
        return L+1;
    }

    //O(N) | O(1)
    public void shiftArray(int[] arr, int n){
        int shift = n % arr.length;
        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, shift-1);
        reverse(arr, shift, arr.length-1);        
    }

    private void reverse(int[] arr, int start, int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    //O(N) | O(1)
    public int getMaxArea(int[] walls){
        int start = 0;
        int end = walls.length - 1;
        int max = 0;

        while(start < end){
            int width = end - start;
            int height = Math.min(walls[start], walls[end]);
            max = Math.max(max, width*height);
            if (walls[start] < walls[end]) start++;
            else end--;
        }
        return max;
    }

    //O(N) | O(N)
    public List<List<Integer>> getIndexSum(int[] arr, int n){
        int start = 0;
        int end = arr.length - 1;
        List<List<Integer>> arrIndexes = new ArrayList<>();
        
        while(start < end){
            int sum = arr[start] + arr[end];
            if (sum == n){
                arrIndexes.add(Arrays.asList(start, end));
                start++;
                end--;
            }
            else if (sum < n) start++;
            else n--;
        }
        return arrIndexes;
    }
}
