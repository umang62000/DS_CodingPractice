/*
Q-You are given an integer array nums where the largest integer is unique.
Find whether the largest element in the array is at least twice as much as every other number in the array.
 If it is, return the index of the largest element, otherwise, return -1.
Logic-
1.We will be finding max1(largest),max2(2nd largest)
if max1>=2max1
*/

public class LargestSumTwiceothers {
    public static int dominantIndex(int[] nums) {
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max1index=0;
        for(int n=0;n<nums.length;n++){
            if(nums[n]>=max1){
                max2=max1;
                max1=nums[n];
                max1index=n;
            }else if(nums[n]>=max2){
                max2=n;
            }
        }
        if(max1>=max2*2){
            return max1index;
        }else{
            return -1;
        }
    }
    public static void main(String[] args) {
        int[] nums={1,0};
        //{1,2,3,4}
        //[1,0] check
        //[0,0,0,1] check
        System.out.println(dominantIndex(nums));
    }
}
