import product.ListOfProducts;  //SOLID-O- можно вносить любые типы продуктов, объединять их в группы, они все будут объединены функционалом Product
import product.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductService {

    public static Map<Product, Integer> productsInBasket = new HashMap<>();

    public static void addProductToBasket(Product product, int number) {
        productsInBasket.put(product, number);
    }

    public static void printListOfProducts(Map<Product, Integer> productList) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-3s %-5s %-10s %-15s %-7s %-10s %-10s\n", "N", "Лот",
                "Товар", "Производитель", "Цена", "Количество", "Стоимость"));
        int numb = 0;
        double sum = 0;
        for (Product product : productList.keySet()) {
            if (productList == null) {
                continue;
            }
            numb++;
            double cost = product.price * productList.get(product);
            sum += cost;
            sb.append(String.format("%-3s %-5s %-10s %-15s %-7s %-10s %-10s\n", numb, product.getID(),
                    product.getName(), product.getFabricator(), product.price, productList.get(product), cost));
        }
        sb.append("********************\n");
        sb.append("СУММА к оплате:  " + sum + "  руб.\n");
        System.out.println(sb);
    }

    public static Product getProductById(int idNumber) {
        for (Product product : ListOfProducts.getProductList()) {
            if (product.getID() == idNumber) {
                return product;
            }
        }
        return null;
    }

    public static void printReceipt(Map<Product, Integer> products) {
        System.out.println("******* ИТОГО к покупке: *********");
        printListOfProducts(products);
        StringBuilder sb = new StringBuilder();
        sb.append("********************");
        sb.append("СПАСИБО за покупку!");
        System.out.println(sb);
    }

    public void recommendations() {
    }
}
