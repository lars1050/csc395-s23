public class Main {

    public static void main(String[] args) {
      System.out.println("\n______ TEST CHECKING _____________");
      Checking checking = new Checking();
      checking.deposit(100.5);
      checking.withdrawal(50);
      System.out.println("Expect $50.50 balance.");
      System.out.printf("Account %d balance is $%.2f\n", checking.number(), checking.balance());

      System.out.println("\n______ TEST SAVINGS _____________");
      Savings savings = new Savings();
      savings.deposit(100.5);
      savings.withdrawal(50);
      System.out.println("Expect $50.50 balance.");
      System.out.printf("Account %d balance is $%.2f\n\n", savings.number(), savings.balance());
    }
}
