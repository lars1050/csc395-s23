// An order is the combination of a cart and tax
// different states apply different salesTax rates.
public class Order {

    private Cart cart;
    private double salesTax;

    private String customerName;
    private String customerEmail;
    private String customerPhone;

    public Order( Cart c, double s, String n, String e, String p ) {
        cart = c;
        salesTax = s;
        customerName = n;
        customerEmail = e;
        customerPhone = p;
      }

    public double total() {
        float total = 0;
        for (int i=0; i < cart.ItemCount; i++) {
          total += cart.Items[i].Price * cart.Items[i].Quantity;
        }
        total += total * salesTax;
        return total;
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





