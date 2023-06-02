import java.util.*;

public class primeTillN {

    public static boolean isprime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 10;
        for (int i = 2; i <= n; i++) {
            boolean prime = isprime(i);
            if (prime) {
                System.out.println(i);
            }
        }

    }

}
