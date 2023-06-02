/*
Ques:Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n 
and is greater in value than n. If no such positive integer exists, return -1.

Approach-o(n)
1. If all given digits in number is in decreasing order then it is already greatest number and not possible to make new 
number greater than that. eg-987654
2.Smallest possible place value(units place,tenth place ,hundred place) eg-2825 we will first try to change unit place 
and if not accomplished then we will try to change tenth place and so on.
3. We will swapping digits with the right place to digit and we will never swap unit place digit
eg-8739487532-if we will swap 4 by lhs digits then 4 will not decide the number would be greater or less but other digit 
will decide
4.If (i+1)th &ith  digit are in decreasing order then we can't increase number by swapping these digits
8739487>5>3>2
5.so we will swap digit when there is increasing order in (i+1)th &ith  digit
87394<8>7>5>3>2
6.we need to find just greater number to 4 from RHS digits(8,7,5,3,2) i.e 5
So number becomes 8739587432
7. We will now left hand side  to the number we swapped in 5th point smallest by sorting
87395(87432)
we will sort the 87432 to make it smallest

Final Answer-8739523478
*/
import java.util.*;
public class NextGreaterElement3 {

    public static void swap(char[]arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static int nextGreaterElement(int n){
        char[]num=Integer.toString(n).toCharArray();
        int i;
        for(i=num.length-1;i>0;i--){
            if(num[i]>num[i-1]){//5th point
                break;
            }
        }
        if(i==0){
            return -1;
        }else{
            int x=num[i-1];
            int min=i;
            for(int j=i;j<num.length-1;j++){//6th point
                if(num[j]>x && num[j]<num[min]){
                    min=j;
                }
            }
            swap(num,i-1,min);
            Arrays.sort(num,i,num.length);
            return Integer.parseInt(new String(num));
        }

    }
    public static void main(String[] args) {
        // int n=230241;
        
        int n=2147483486;
        System.out.println(nextGreaterElement(n));
        // nextGreaterElement(n);
    }
}
