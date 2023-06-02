/**
 * SelectionSort
 */
public class SelectionSort {
    static void sort(int[]arr){
        for (int i = 0; i < arr.length-1; i++) {
            int mi=i;//minimum index
            for(int j=i+1;j<arr.length;j++){
                if(arr[mi]>arr[j]){
                    mi=j;
                }
            }
            //Swap minimum index with i
            int temp=arr[mi];
            arr[mi]=arr[i];
            arr[i]=temp;
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
