package piwords;

public class DigitsToStringConverter {
    /**
     * Given a list of digits, a base, and an mapping of digits of that base to
     * chars, convert the list of digits into a character string by applying the
     * mapping to each digit in the input.
     *
     * If digits[i] >= base or digits[i] < 0 for any i, consider the input
     * invalid, and return null.
     * If alphabet.length != base, consider the input invalid, and return null.
     *
     * @param digits A list of digits to encode. This object is not mutated.
     * @param base The base the digits are encoded in.
     * @param alphabet The mapping of digits to chars. This object is not
     *                 mutated.
     * @return A String encoding the input digits with alphabet.
     */
    public static String convertDigitsToString(int[] digits, int base,
                                               char[] alphabet) {
        if (alphabet.length != base) {
            return null;
        }
        int[] digitsNew = digits.clone();
        StringBuilder piString = new StringBuilder();
        for (int i: digitsNew) {
            if (i >= base || i < 0) {
                return null;
            }
            piString.append(alphabet[i]);
        }

        return piString.toString();
    }

//    public static void main(String[] args) {
//        String a = convertDigitsToString(new int[]{3, 17, 18, 16, 11, 14, 10, 25}, 26,
//                new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
//                        'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
//                        'x', 'y', 'z'});
//        System.out.println(a);
//    }
}
