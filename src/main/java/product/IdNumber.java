package product;

public class IdNumber {
    protected static int lastID = 1; /*избегание магических чисел, если придется продолжать работу
     уже существующего магазина, то не придется менять код, нужно
     будет только задать начальное значение*/
    protected static int valueId = 0;
    public int idNumberLast;

    public IdNumber() {
        valueId += lastID;
        this.idNumberLast = valueId;
    }

    public int getValueId() {
        return idNumberLast;
    }

    @Override
    public String toString() {
        return "Товар:  ";
    }
}
