/**
 * NotaPlaindrome
 */
//import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
import java.util.*;
public class SmallestNonPalindromic {
    public static String sortString(String input){
        char tempArray[]=input.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }   
    static String reverse(String input)
    {
        char[] a = input.toCharArray();
        int l, r = a.length - 1;
        for (l = 0; l < r; l++, r--) 
        {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
        }
        return String.valueOf(a);
     }
    public static String smallestNonPalindromic(String s){
        s=sortString(s);
        String reverseString = reverse(s);
        if(!s.equals(reverseString)){
            return s;
        }else{
            return "-1";
        }
    }
    public static void main(String[] args)  {
        String str="owaujepihg";
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //     String str = reader.readLine();
            
        String output=smallestNonPalindromic(str);
        System.out.println(output);
    }
}