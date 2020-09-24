public class Pset1 {
    public static boolean isAllCharacterUnique(String sIn) {
        char[] chars = sIn.toCharArray();
        for (char i: chars) {
            int count = 0;
            for (int j=0;j<sIn.length();j++) {
                if (sIn.charAt(j) == i) {
                    count++;
                }
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
    public static boolean isPermutation(String sIn1, String sIn2) {
        char[] chars1 = sIn1.toCharArray();
        if (sIn1.length() != sIn2.length()) {
            return false;
        }
        for (char i: chars1) {
            if (sIn2.indexOf(i) == -1) {
                return false;
            }
        }
        return true;
    }
}
