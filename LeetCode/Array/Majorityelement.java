import java.util.HashMap;

// Time & space using hashmap approach -o(n)
//see also moore voting algo-o(1)

public class Majorityelement {
    public static int Majorityelement(int[] arr){
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                int count=hm.get(arr[i])+1;
                if(count>arr.length/2){
                    return arr[i];
                }else{
                hm.put(arr[i], count);
                }

            }else{
                hm.put(arr[i], 1);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[]arr={3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println(Majorityelement(arr));
    }
}
