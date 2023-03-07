package product;  //SOLID-S- только с теми функциями, для которых он создан

public class Product {
    private NameProduct name;
    private Fabricator fabricator;
    public int number;

    public double price = 0.00;
    private final int ID;
    public int rating;

    public Product(NameProduct name, int number, Fabricator fabricator, Double price, IdNumber idNumber, int rating) {
        this.name = name;
        this.number = number;
        this.fabricator = fabricator;
        this.price = price;
        this.ID = idNumber.getValueId();
        this.rating = rating;
    }

    public NameProduct getName() {
        return name;
    }

    public Fabricator getFabricator() {
        return fabricator;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Лот " + ID + '{' +
                "  Наименование:'" + name + '\'' +
                " Производитель:'" + fabricator + '\'' +
                " Цена (руб.): " + price +
                "  Рейтинг товара: " + rating +
                '}' + "\n";
    }
}
