
import java.util.ArrayList;
import java.util.Collections;

public class TestAcc {

    public static void main(String[] args) {

        Account a = new Account("simon", 20);
        System.out.println(a.getId());
        System.out.println(a.getBalance());
        System.out.println(a);


        ArrayList<Account> l = new ArrayList<>();

        l.add(new Account("man", 30));
        l.add(new Account("eric", 100));
        l.add(new Account("norman", 10));

        Collections.sort(l);
        System.out.println(l);


        Collections.sort(l, new AccountComparator());
        System.out.println(l);

        System.out.println(new Account("sun", 5000));


        l = new ArrayList<>();

        l.add(new Account("himan", 1));
        l.add(new Account("hieric", 100));
        l.add(new Account("hinorman", 10));
        l.add(new Account("lucas", 200));
        l.add(new Account("alex", 40));
        l.add(new Account("gemma", 150));


        Collections.sort(l);
        System.out.println(l);

        Collections.sort(l);
        System.out.println(l);

        Collections.sort(l, new AccountComparator());
        System.out.println(l);

        Collections.sort(l, new AccountComparator());
        System.out.println(l);



    }


}
