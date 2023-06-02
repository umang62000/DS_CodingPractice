/*
Approach-
Storage b/w ith & jth wall ->(j-i)*Math.min(arr[j],arr[i])  -->Area of rectangle =width*height

1.Approach -O(n^2)
  -find all combination  of 0th wall to ith wall-(0,1)(o,2).....(0,8) and find storage
  -find all conbination of 1th wall to ith wall -(1,2)(1,2)......(1,8) and find storage
  -Repeat till ith wall
  -total combination=n*(n-1)*(n-2)*.....*1=n^2
2.Approach -O(n)
-Take ith wall as 0 and jth wall as 8 and find its storage
-now move the smaller wall index :if ith wall is shorter then increase i and if jth wall is shorter then decrease j
-Do this while i<j
*/
public class ContainerMaxWater {
    public static int maxArea(int[]height){
        int l=0;
        int r=height.length-1;
        int omax=Integer.MIN_VALUE;
        while(l<r){
            int storage=(r-l)*Math.min(height[l],height[r]);
            
                omax=Math.max(storage, omax);
                if(height[l]<height[r]){
                    l++;
                }else{
                    r--;
                }
            
        }
        return omax;
    }
    public static void main(String[] args) {
        int[]height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
