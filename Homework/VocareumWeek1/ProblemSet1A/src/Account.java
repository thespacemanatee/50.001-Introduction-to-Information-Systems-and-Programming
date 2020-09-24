import java.util.Date;

public class Account {
    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated;
    public Account() {
        setId(0);
        setBalance(0);
    }
    public Account(int id,double balance) {
        setId(id);
        setBalance(balance);
    }
    public int getId() {
        return id;
    }
    public void setId(int newId) {
        id = newId;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double newBalance) {
        balance = newBalance;
    }
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public static void setAnnualInterestRate(double newSetAnnualInterestRate) {
        annualInterestRate = newSetAnnualInterestRate;
    }
    public Date getDateCreated() {
        return dateCreated;
    }
    public static double getMonthlyInterestRate() {
        return getAnnualInterestRate()/12;
    }
    public double getMonthlyInterest() {
        double monthlyInterestRate = getMonthlyInterestRate()*0.01;
        return getBalance()*(monthlyInterestRate);
    }
    public void withdraw(double x) {
        double balance = getBalance();
        balance -= x;
        setBalance(balance);
    }
    public void deposit(double y) {
        double balance = getBalance();
        balance += y;
        setBalance(balance);
    }

}