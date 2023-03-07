import product.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        setProducts();
        welcomeShop();
        startShopping();
        welcomeShop();
        ListOfProducts list = new ListOfProducts();
        list.costFilter(12.00, 65.00);
        list.ratingFilter();
        list.wordFilter("САР");
        list.wordFilter("Baby");

    }


    public static void welcomeShop() {
        System.out.println("*****Приветствуем дорогого покупателя в нашем магазине!*****\n");
        ListOfProducts v = new ListOfProducts();
        v.printMenu();
    }

    public static void startShopping() {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        while (true) {
            System.out.println("Чтобы поместить товар в корзину\n введите, пожалуйста, лот продукта и его количество через пробел,\n" +
                    " либо \"end\" для завершения покупок:  ");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            final String[] inputRaw = input.split(" ");
            int purchaseProduct = Integer.parseInt(inputRaw[0]);//Лот
            int numberOfProduct = Integer.parseInt(inputRaw[1]);//кол-во
            productService.addProductToBasket(productService.getProductById(purchaseProduct), numberOfProduct);
        }
        System.out.println("ПРОСМОТР КОРЗИНЫ:");
        productService.printListOfProducts(productService.productsInBasket);
        Order order = new Order(productService.productsInBasket);
        System.out.println("Желаете забрать заказ из магазина (введите S)  или воспользоваться доставкой (введите D)? ");
        String releaseOfGoods = scanner.nextLine();
        if (releaseOfGoods == "S") {
            System.out.println("Вы выбрали забрать заказ " + order.getOrderNumber() + " из магазина! Ваш чек: ");
            productService.printReceipt(productService.productsInBasket);
        } else {
            Delivery delivery = new Delivery(order);
            System.out.println("Введите адрес доставки: ");
            String address = scanner.nextLine();
            System.out.println("Вы оформили заказ " + order.setOrderNumber() + " и доставку по адресу " + address);
            System.out.println("Трек-номер для отслеживания доставки заказа: " + delivery.getTrackNumber());
            //УЗНАТЬ СТАДИЮ ДОСТАВКИ
            System.out.println("Чтобы узнать стадию доставки, введите трек-номер");
            delivery.getDeliveryStage(scanner.nextLine());
            //Заказ изменил стадию доставки
            delivery.stage1 = "Выполнено";
            delivery.stage2 = "Выполнено";
            //Текущая стадия доставки стала
            delivery.getDeliveryStage(scanner.nextLine());
        }
    }

    public static void setProducts() {
        ListOfProducts.setProductList(new Product(NameProduct.CAP, 16, Fabricator.BabyHOUSE, 45.00,
                new IdNumber(), 8));
        ListOfProducts.setProductList(new Product(NameProduct.CAP, 10, Fabricator.PinkFABRICA, 85.00,
                new IdNumber(), 10));
        ListOfProducts.setProductList(new Product(NameProduct.FORK, 6, Fabricator.BabyHOUSE, 35.00,
                new IdNumber(), 8));
        ListOfProducts.setProductList(new Product(NameProduct.FORK, 3, Fabricator.SuperTEENS, 25.00,
                new IdNumber(), 2));
        ListOfProducts.setProductList(new Product(NameProduct.HairBALSAM, 111, Fabricator.SuperTEENS, 95.00,
                new IdNumber(), 6));
    }

}
