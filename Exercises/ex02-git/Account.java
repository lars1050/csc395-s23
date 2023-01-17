public interface Account {

    /** getter for the current balance */
    public double balance();

    /** make a deposit (adding to the balance) */
    public void deposit(double amount);

    /** make a withrdawal (if not more than balance) */
    public void withdrawal(double amount);

    /** getter for unique account number */
    public int number();
}
