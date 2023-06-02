public class Power {
    public static int calculatePower(int x,int y){
        if(y==0){
            return 1;
        }
        return x* calculatePower(x, y-1);
    }
    public static void main(String[] args) {
        System.out.println(calculatePower(2,3));
    }
}
