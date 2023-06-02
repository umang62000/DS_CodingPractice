public class FirstIndexOccurance {

    static int firstIndex(int[]arr,int idx,int x){
        if(idx==arr.length){
            return -1;
        }
        if(arr[idx]==x){
            return idx;
        }else{
            return firstIndex(arr, idx+1, x);
        }
    }
    static int lastIndex(int[]arr,int idx,int x){

        if(idx==arr.length){
            return -1;
        }

        int liila=lastIndex(arr, idx+1, x);//last index in last array

        if(liila==-1){
            if(x==arr[idx]){
                return idx;
            }else{
                return -1;
            }
        }else{
            return liila;
        }
    }
    public static void main(String[] args) {
        int[]arr={2,3,6,9,8,3,2,6,2,4};
        // System.out.println(firstIndex(arr, 1, 3));
        System.out.println(lastIndex(arr, 0, 3));
    }
}
//In last index first we are going till last and then finding last index while returning
//Alternate approach just for more insight
// public static int lastOccurenceFinder(int arr[], int idx, int element){
//     if(idx == -1) return -1;
//     if (arr[idx] ==  element )return idx;
//     int theIndex = lastOccurenceFinder(arr, idx - 1 , element); 
//     if(theIndex != -1 ) return theIndex;
//     else return -1;  
// }