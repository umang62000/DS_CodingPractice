import java.util.*;
/**
 * BubleSort
 */
public class BubleSort {
    public static void sort(int[]arr){
        for(int i=0;i<=arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    //swap(arr,j,j+1);
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                }
            }
        }
    }
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    public static void main(String[] args) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90}; 
        sort(arr);
        printArray(arr);
    }
}