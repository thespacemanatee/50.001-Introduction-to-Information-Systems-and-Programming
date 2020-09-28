import java.util.ArrayList;

public class Permutation {
    private String in;
    private ArrayList<String> a = new ArrayList<>();
    // additional attribute if needed
    private int left;

    Permutation(final String str){
        in = str;
        // additional initialization if needed
        left = 0;
    }

    public static String swap(String in, int i, int j) {
        char[] charArray = in.toCharArray();
        char a = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = a;
        return String.valueOf(charArray);
    }

    public void permute(){
        // produce the permuted sequences of 'in' and store in 'a', recursively
        int length = in.length();
        int right = length - 1;

        for (int i = left; i <= right; i++) {
            in = swap(in,left,i);
            left += 1;
            permute();
            left -= 1;
            in = swap(in,left,i);
            if (a.contains(in)) {
                continue;
            }
            a.add(in);
        }
    }

    public ArrayList<String> getA(){
        return a;
    }
}

class TestPermutation {
    public static void main(String[] args) {
        ArrayList<String> v;

        Permutation p = new Permutation("hat");
        p.permute();
        v = p.getA();
        System.out.println(v);

    }
}

