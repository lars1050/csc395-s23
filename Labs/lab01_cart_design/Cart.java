// A collection of elements in a cart
// CartContents "has a" CartEntry - using composition
public class Cart {
    int ItemCount; // number of elements in cart
    CartItem[] Items;
}