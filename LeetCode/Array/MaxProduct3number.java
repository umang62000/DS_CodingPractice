/**
 * MaxProduct3number
 */
 /*
Ques-Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
Example 1:
Input: nums = [1,2,3]
Output: 6

Logic-
1.first we will doing this in sorted array[Note:In ques we can have unsorted array]
2.Given sorted array->[min1,min2,.......max3,max2,max1]
MaxProduct=Math.Max((min1*min2*max1),(max3*max2*max1))
eg-[-100,-90,1,2,3,4]
Max Product=min1*min2*max1
eg-[1,2,4,5,6]
Max Product- max3*max2*max1

Approach*
1.We will be sorting array and apply the above approach in which complexity=o(nlogn) because Arrays.sort=o(nlogn)
2.We will be find all 5 numbers min1,min2,max3,max2,max1 in O(n) and simply apply above login.In this Complexity=O(n)
 */
public class MaxProduct3number {
//Using Approach2 in O(n)
    public static int maximumProduct(int[] nums) {
            int max1=Integer.MIN_VALUE;
            int max2=Integer.MIN_VALUE;
            int max3=Integer.MIN_VALUE;
            int min1=Integer.MAX_VALUE;
            int min2=Integer.MAX_VALUE;
            for(int n:nums){
                if(n<=min1){
                    min2=min1;
                    min1=n;
                }else if(n<=min2){//n lies between min 1 and min2
                    min2=n;
                }
                if(n>=max1){//largest number
                    max3=max2;
                    max2=max1;
                    max1=n;
                }else if(n>=max2){//n lies between max2 and max1
                    max3=max2;
                    max2=n;
                }else if(n>=max3){//n lies between max3 and max2

                    max3=n;
                }
            }
            return Math.max((min1*min2*max1), (max3*max2*max1));
    }
    public static void main(String[] args) {
        //int[]nums={-100,-90,1,2,3,4};
        int[]nums={1,2,3,4};
        System.out.println(maximumProduct(nums));
    }
}