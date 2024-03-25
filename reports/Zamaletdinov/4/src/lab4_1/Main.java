public class Main {
    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.addItem("Product 1", 10.99);
        payment.addItem("Product 2", 5.49);
        payment.addItem("Product 3", 7.79);

        payment.displayItems();
        System.out.println("Total price: $" + payment.getTotalPrice());
    }
}