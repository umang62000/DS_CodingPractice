import java.util.*;
/**
 * BinarySearch
 * 
 */
public class BinarySearch {
    public static int search(int[]arr,int x){
        int l=0;
        int r=arr.length-1;
        while(l<=r){
            int m=(l+r)/2;
            if(arr[m]==x){
                return m;
            }else if(arr[m]<x){
                l=m+1;
            }else {
                r=m-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[]arr={2, 3, 4, 10, 40,50,70,80 };
        int element=search(arr,70);
        if(element==-1){
            System.out.println("Element Not found");
        }else{
            System.out.println("Element found at index "+element);
        }
    }
}