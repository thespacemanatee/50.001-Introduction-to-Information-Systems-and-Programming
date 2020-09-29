import java.util.ArrayList;

public class PermutationV2 {
    private final String in;
    private ArrayList<String> a = new ArrayList<>();
    private final int strLength;
    // additional attribute if needed

    PermutationV2(final String str){
        in = str;
        // additional initialization if needed
        strLength = in.length();
    }


    public void permute(String in, String ans)
    {
        if (in.length() == 0) {
            return;
        }

        for (int i = 0; i < in.length(); i++) {

            char c = in.charAt(i);
            String out = in.substring(0, i) +
                    in.substring(i + 1);
            if (!a.contains(ans + c) && (ans + c).length() == strLength) {
                a.add(ans + c);
            }
            permute(out, ans + c);

        }
    }

    public void permute(){
        // produce the permuted sequences of 'in' and store in 'a', recursively
        permute(in,"");

    }

    public ArrayList<String> getA(){
        return a;
    }
}

class TestPermutationV2 {
    public static void main(String[] args) {
        ArrayList<String> v;

        PermutationV2 p = new PermutationV2("hath");
        p.permute();
        v = p.getA();
        System.out.println(v);

    }
}

