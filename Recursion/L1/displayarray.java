import java.util.*;

public class displayarray {

    // expectation- idx s end tak print kr de
    // faith- idx+1 s end tak print krna jaanta h
    static void display(int[] arr, int idx) {
        if (arr.length == idx) {
            return;
        }
        System.out.println(arr[idx]);
        display(arr, idx + 1);
    }
    //exp- end s idx tak print kr dega
    //faith- end s idx+1 print krna jaanta h
    static void displayReverse(int[] arr, int idx) {
        if (idx==arr.length) {
            return;
        }
        displayReverse(arr, idx + 1);
        System.out.println(arr[idx]);

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        // display(arr, 0);
        displayReverse(arr, 0);
    }
}
