public class checkPalindrome {
    public static Boolean checkPalindrome(String input){
        int left=0;
        int right=input.length()-1;
        while(left<right){
            if(input.charAt(left)!=input.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
        }
    public static void main(String[] args) {
        String s="12344321";
        System.out.println(checkPalindrome(s));
    }
}
