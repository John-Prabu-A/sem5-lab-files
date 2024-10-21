public class BankAccount implements CreditCard {
    private double balance;

    BankAccount(double bal) {
        this.balance = bal;
    }

    public double dollar() {
        return 0.012 * balance;
    }

    public double rupees() {
        return balance;
    }

    public double pounds() {
        return 0.009 * balance;
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1000);
        System.out.println("Indian Val ₹" + acc.rupees());
    }

}

interface CreditCard {
    double balance = 0;

    double dollar();

    double rupees();

    double pounds();
}