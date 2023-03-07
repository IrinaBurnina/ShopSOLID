import product.Product;

import java.util.Map;
import java.util.Random;

public class Order {
    private Map<Product, Integer> order;
    private int orderNumber;

    protected Order(Map<Product, Integer> order) {
        this.order = order;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int setOrderNumber() {
        Random random = new Random();
        orderNumber = random.nextInt(5);
        return orderNumber;
    }

    public void returnOrder(int orderNumber) {

    }
}
