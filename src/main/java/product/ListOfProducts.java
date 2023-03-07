package product;

import java.util.*;

public class ListOfProducts implements FunctionsByProducts {
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

    @Override
    public void printMenu() {
        System.out.println(getProductList());
    }

    //DRY -объединила в одном методе фильтрацию по названию и производителю
    @Override
    public void wordFilter(String word) {
        System.out.println("Фильтр по названию/производителю товара, введите слово для поиска: " + word);
        getProductList().stream()
                .filter(x -> x.getName().toString().contains(word) || x.getFabricator().toString().contains(word))
                .forEach(System.out::println);
    }

    @Override
    public void costFilter(Double costMin, Double costMax) {
        System.out.println("Фильтр по цене. Введите значение максимальной цены в формате руб..коп.(например, 55.00):");
        Scanner scanner = new Scanner(System.in);
        Double max = scanner.nextDouble();
        System.out.println("Введите значение минимальной цены:");
        Double min = scanner.nextDouble();
        getProductList().stream()
                .filter(x -> x.price < max)
                .filter(x -> x.price > min)
                .forEach(System.out::println);
    }

    @Override
    public void ratingFilter() {
        System.out.println("Фильтр по рейтингу. Введите значение минимального рейтинга (от 0 до 10): ");
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        getProductList().stream()
                .filter(x -> x.rating > min)
                .forEach(System.out::println);
    }
}
