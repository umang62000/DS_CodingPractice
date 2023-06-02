public class Factorial {
    
    public static int printFactorial(int n){
        if(n==1){
            return 1;
        }
        return n*printFactorial(n-1);

    }
    public static void main(String[] args) {
        System.out.println(printFactorial(5)); 
    }
}
