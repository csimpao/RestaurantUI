public class Order {
    private double subtotal;
    private double tax;
    private double totalTax;
    private double total;

    public Order() {
        subtotal = 0.00;
        tax = 0.13;
        totalTax = 1.13;
        total = 0.00;
    }

    public double getSubtotal() {
        return subtotal;
    } 

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

    public double getTotalTax() {
        return totalTax;
    }
}
