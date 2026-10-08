public class Cart {
    private int[] prices;
    private int maxItems;
    private int count;
    private final String cartId;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.maxItems = maxItems;
        this.prices = new int[maxItems];
        this.count = 0;
    }

    public void addItem(int price) {
        if (this.count < this.maxItems && price >= 0) {
            this.prices[this.count] = price;
            this.count++;
        }
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < this.count; i++) {
            total += this.prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return this.count;
    }

    public String getCartId() {
        return this.cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}