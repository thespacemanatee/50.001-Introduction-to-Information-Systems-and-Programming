public class CheckingAccount extends Account {
    public CheckingAccount() {
        setId(0);
        setBalance(0);
    }

    public CheckingAccount(int id,double balance) {
        setId(id);
        setBalance(balance);
    }

    @Override
    public void withdraw(double x) {
        if (this.getBalance() - x < -5000) {
            System.out.println("over limit");
        } else {
            double balance = getBalance();
            balance -= x;
            setBalance(balance);
        }
    }
}
