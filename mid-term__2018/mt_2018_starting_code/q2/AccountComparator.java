
import java.util.Comparator;
//starting code
public class AccountComparator implements Comparator<Account> {

    @Override
    public int compare(Account a, Account b) {
        char[] first = a.getId().toCharArray();
        char[] second = b.getId().toCharArray();

        for (int i = 0; i < first.length && i < second.length; i++) {
            if (first[i] > second[i]) {
                return 1;
            } else if (first[i] < second[i]) {
                return -1;
            }
        }
        return 0;
    }
}

