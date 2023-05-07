class LineItem {
    private Item item;
    private int quantity;

    public LineItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return item.getPrice() * quantity;
    }

    public String toString() {
        return String.format("%s (x%d) - %.2f", item.getName(), quantity, getTotalAmount());
    }
}