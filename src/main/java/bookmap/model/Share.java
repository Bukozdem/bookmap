package bookmap.model;

public class Share {
    private int price;
    private int size;

    public Share() {
    }

    public Share(int price, int size) {
        this.price = price;
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
