import java.util.Arrays;

public class Palindrome {
    public static String isPalindrome(String a) {
        if (isPalindrome(a.toCharArray())) {
            return a + " is a palindrome.";
        } else {
            return a + " is not a palindrome.";

        }
    }

    public static boolean isPalindrome(char[] S) {
        if (S.length == 0 || S.length == 1) {
            return true;
        } else if (S[0] == S[S.length - 1]) {
            return isPalindrome(Arrays.copyOfRange(S, 1, S.length - 1));
        } else {
            return false;
        }
    }


//    public static boolean isPalindrome(String a) {
//        return isPalindrome(a,0,a.length()-1);
//    }
//
//    public static boolean isPalindrome(String a, int left, int right) {
//        if (left>right) {
//            return true;
//        } else if (a.charAt(left) != a.charAt(right)){
//            return false;
//        }
//        return isPalindrome(a, left+1, right-1);
//    }

    public static void main(String[] args) {
        String a = "aabbaa";
        String b = "abcdca";
        String c = "abcdcba";
        System.out.println(isPalindrome(a));
        System.out.println(isPalindrome(b));
        System.out.println(isPalindrome(c));
    }
}
