package sparta.buggerOrder;

public class Amount extends Menu{
    double price;

    int cnt;
    public Amount (String name, double price, int cnt) {
        this.name = name;
        this.price = price;
        this.cnt = cnt;
    }

    public int setCnt(int num) {
        return cnt + num;
    }

    public int getCnt() {
        return cnt;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
