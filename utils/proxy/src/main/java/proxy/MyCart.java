package proxy;

public class MyCart {

    private int items;
    private int amount;

    public MyCart(int items, int amount) {
        this.items = items;
        this.amount = amount;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
