/*

1.Approach 1:o(nlogn)
Take square and Arrays.sort
2.Approach 2:o(n)
-Take i at 0 index & j aat last index of inc array
-Take square of both and place the largest square at end And if ith square is largest then increase i and if j is largest
then decrease j

*/
public class SquaresSortedArray {

    public static int[] sortsquares(int []arr){
        int l=0;
        int r=arr.length-1;
        int[]temp=new int[arr.length];
        int k=arr.length-1;
        while(l<r){
            if(Math.pow(arr[l], 2)<Math.pow(arr[r], 2)){
                temp[k]=(int)Math.pow(arr[r], 2);
                r--;
                k--;
            }else if(Math.pow(arr[l], 2)>Math.pow(arr[r], 2)){
                temp[k]=(int)Math.pow(arr[l], 2);
                l++;
                k--;
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        int []arr={-4,-1,0,3,10};
        int[]sq=sortsquares(arr);
        for(int i=0;i<sq.length;i++){
            System.out.print(sq[i]+" ");
        }
    }
}
