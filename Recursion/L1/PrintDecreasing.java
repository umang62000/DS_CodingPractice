public class PrintDecreasing{

    public static void printdescreasing(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printdescreasing(n-1);
    }
    public static void main(String[] args) {
        printdescreasing(5);
    }
}