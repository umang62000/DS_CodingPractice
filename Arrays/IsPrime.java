import java.util.*;
/*
for each number 
if number has factor then it will divide till squareroot n
after squareroot of n factor repeats.

pq =n
p<=rootn||q<=rootn
*/
public class IsPrime{
    public static boolean isprime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        System.out.println(isprime(n));
    }
}