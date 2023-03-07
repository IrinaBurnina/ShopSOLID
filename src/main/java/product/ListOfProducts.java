package product;

import java.util.*;

public class ListOfProducts {//SOLID-I- разделение функционала на отдельные классы Order,Delivery, Product, ListOfProducts
    private static List<Product> products = new LinkedList<>();

    public static List<Product> getProductList() {
        return products;
    }

    public static void setProductList(Product product) {
        getProductList().add(IdNumber.valueId - 1, product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список продуктов: \n");
        for (int i = 0; i < products.size(); i++) {
            sb.append(i + ". " + products.get(i) + '\n');
        }
        return sb.toString();
    }
}
