import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Ques:Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

*/
public class Majorityelement2 {
    public static List<Integer> Majorityelement(int[]nums){
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                int count=hm.get(nums[i])+1;
                hm.put(nums[i], count);
            }else{
                hm.put(nums[i], 1);
            }
        }
        List<Integer> list=new ArrayList<Integer>();
        for(int key:hm.keySet()){
            if(hm.get(key)>nums.length/3){
                list.add(key);
            }
        }
        return list;

    }
    public static void main(String[] args) {
        int[] nums= {1,2};
        List<Integer>list=Majorityelement(nums);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
    }
}
