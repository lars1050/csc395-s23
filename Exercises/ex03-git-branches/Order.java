// An order is the combination of a cart and tax
// different states apply different salesTax rates.
public class Order {

    private Cart cart;

    private String customerName;
    private String customerEmail;
    private String customerPhone;

    public Order( Cart c, String n, String e, String p ) {
        cart = c;
        customerName = n;
        customerEmail = e;
        customerPhone = p;
      }

    public double total() {

        return 0.0;
    }

    public String customerName() {
      return customerName;
    }
    public String customerEmail() {
      return customerEmail;
    }
    public String customerAddress() {
      return customerPhone;
    }
}





