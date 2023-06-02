public class MaxArray {
    
    static int maxofarray(int[]arr,int idx){

        if(idx==arr.length-1){
            return arr[idx];
        }

        int misa=maxofarray(arr, idx+1);
        if(misa<arr[idx]){
            return arr[idx];
        }else{
            return misa;
        }
    }
    public static void main(String[] args) {
        int[]arr={22,2,33,7,19};
        System.out.println(maxofarray(arr, 0));
    }
}
