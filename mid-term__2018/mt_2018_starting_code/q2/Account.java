
import java.util.Date;

//starting code
public class Account implements Comparable<Account> {
    private String id;
    private double balance;
    private Date dateCreated;

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "Account:" + getId();
    }

    @Override
    public int compareTo(Account a) {
        if (this.balance > a.getBalance()) {
            return 1;
        } else if (this.balance < a.getBalance()) {
            return -1;
        }

        return 0;
    }
}

