public class ToyNode {
    private String name;
    private double price;
    private  int count;
    private  ToyNode next;

    public ToyNode(String name, double price, int count, ToyNode next) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.next = next;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public ToyNode getNext() {
        return next;
    }
    public void setNext(ToyNode next) {
        this.next = next;
    }
    public String toString() {
        return "Toy: " + this.getName() + " price: " + this.getPrice() + "=" + this.getCount();
    }
}
