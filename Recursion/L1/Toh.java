import java.util.*;

// Tower of hanoi
public class Toh {
    public static void toh(int n, int t1id,int t2id,int t3id){
        if(n==0){
            return;
        }
        toh(n-1,t1id,t3id,t2id);
        System.out.println(n+"["+t1id+"->"+t2id+"]");
        toh(n-1, t3id, t2id, t1id);
    }
    public static void main(String[] args) {
        toh(3,10,11,12);//n is number of discs, t1id is t1id tower,....) 
    }
    
}
