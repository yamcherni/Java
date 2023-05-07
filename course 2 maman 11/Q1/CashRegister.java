import java.util.ArrayList;
import java.util.List;

public class CashRegister {
    private double cashTotal;
    private List<LineItem> currentPurchase;

    public CashRegister() {
        cashTotal = 0.0;
        currentPurchase = new ArrayList<LineItem>();
    }

    public CashRegister(double initialCash) {
        cashTotal = initialCash;
        currentPurchase = new ArrayList<LineItem>();
    }

    public void addItem(Item item, int quantity) {
        LineItem line = new LineItem(item, quantity);
        currentPurchase.add(line);
    }

    public String getCurrentPurchase() {
        StringBuilder sb = new StringBuilder();
        for (LineItem line : currentPurchase) {
            sb.append(line.toString()).append("\n");
        }
        return sb.toString();
    }

    public double getCurrentPurchaseTotal() {
        double total = 0.0;
        for (LineItem line : currentPurchase) {
            total += line.getTotalAmount();
        }
        return total;
    }

    public double receivePayment(double amountPaid) {
        double change = amountPaid - getCurrentPurchaseTotal();
        cashTotal += getCurrentPurchaseTotal();
        currentPurchase.clear();
        return change;
    }

    public double getCashTotal() {
        return cashTotal;
    }
}
