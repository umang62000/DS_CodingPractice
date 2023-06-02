import java.util.*;
public class gce1 {
    public static void main(String[] args) {
        int[]a1={1,1,1,2,2,3,5};
        int[]a2={1,1,2,2,4,5};
        HashMap<Integer,Integer> fmap =new HashMap<>();
        for(int val:a1){
            if(fmap.containsKey(val)){
                int ov=fmap.get(val);
                int nf=ov+1;
                fmap.put(val,nf);
            }else{
                fmap.put(val, 1);
            }
        }
        for(int val:a2){
            if(fmap.containsKey(val)){
                System.out.println(val);
                fmap.remove(val);
            }
        }
    }
}
