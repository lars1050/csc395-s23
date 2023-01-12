public class Main {
  public static void main(String[] args) {

    // Compile a list of items to place in a cart
    CartItem[] itemsInCart = new CartItem[5];
    for (int i=0; i<5; i++) {
      itemsInCart[i] = new CartItem();
      // arbitrary values for demonstration purposes
      itemsInCart[i].Price = i*2;
      itemsInCart[i].Quantity = i;
    }

    // Create a cart for purchases and place the list of items in the cart 
    Cart purchases = new Cart();
    purchases.Items = itemsInCart;
    purchases.ItemCount = 5;

    // Finish the purchase by putting it into an Order
    Order order1 = new Order(purchases, .077,"Suzy Queue","queue@gmail.com","612-111-2222");

    // Get total price of order
    System.out.println("Order for "+order1.customerName() + " complete. Contat at "+order1.customerEmail());
    System.out.printf("Order Total $%.2f %n", order1.total());
  }
}


