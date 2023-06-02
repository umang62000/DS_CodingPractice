import java.util.*;
public class gce2 {
    public static void main(String[] args) {
        int[] a1={1,1,2,2,2,3,5};
        int[] a2={1,1,1,2,2,4,5};
        HashMap<Integer,Integer>fm=new HashMap<>();
        for(int val:a1){
            if(fm.containsKey(val)){
                int ov=fm.get(val);
                int nv=ov+1;
                fm.put(val,nv);
            }else{
                fm.put(val,1);
            }
        }
        for(int val:a2){
            if(fm.containsKey(val)){
                if(fm.get(val)>0){
                    System.out.println(val);
                    fm.put(val,fm.get(val)-1);
                }
            }
        }
    }
}
