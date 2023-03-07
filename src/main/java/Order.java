import product.Product;

import java.util.Map;
import java.util.Random;

public class Order {
    private Map<Product, Integer> order;
    private int orderNumber = 0;

    protected Order(Map<Product, Integer> order) {
        this.order = order;
        setOrderNumber();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber() {
        Random random = new Random();
        orderNumber = random.nextInt(5);
    }

    public void returnOrder(int orderNumber) {

    }
}
