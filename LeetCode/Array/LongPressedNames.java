
import java.util.*;

/**
 * LongPressedNames
 */
// Approach-
// 1.Take 2 pointer i & j 
// i will iterating at name and j will be iterating typed characters 
// if char at i==j then i++,j++ and if char at i!=j&& char at j==chatAt j-1(means long pressed)
// Time complexity=-O(n+m),Space o(1)

public class LongPressedNames {
    public static boolean isLongpressedboolean(String name,String typed){
        int np=0;
        int tp=0;
        while(np<name.length()&&tp<typed.length()){
            if(name.charAt(np)==typed.charAt(tp)){
                np++;
                tp++;
            }else if(tp>0 && typed.charAt(tp)==typed.charAt(tp-1)){
                    tp++;
            }else{
               return false; 
            }
        }
        //if all the characters of name string left unmatched
        //eg-name="abc" typed="aabb"
        if(np<name.length()){
            return false;
        }else{
            //if there is some reductant letters in typed for which we can still have a match
            //eg-name-abc typed-abccccc
            while (tp<typed.length()-1){
                if(tp<typed.length()){
                    if(typed.charAt(tp-1)!=typed.charAt(tp)){
                        return false;
                    }else{
                        tp++;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isLongpressedboolean("alex", "aallex"));
        // System.out.println(isLongpressedboolean("abc", "aabb"));
        // System.out.println(isLongpressedboolean("abc", "abccccc"));
    }
}