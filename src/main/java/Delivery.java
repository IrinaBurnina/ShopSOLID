import java.util.Random;
import java.util.Scanner;

public class Delivery {
    protected int trackNumberLength = 12; //magic число
    protected String stage1 = null;
    protected String stage2 = null;
    protected String stage3 = null;

    public Delivery(Order order) {
        Random random = new Random();
        trackNumber = order.getOrderNumber() + " - " + random.nextInt(trackNumberLength);
    }

    private String trackNumber;

    public String getTrackNumber() {
        return trackNumber;
    }


    public void getDeliveryStage(String trackNumber) {
        System.out.println("Введите трек-номер для просмотра стадии заказа в системе доставки");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.nextLine().equalsIgnoreCase("end"))
            if (trackNumber.equalsIgnoreCase(scanner.nextLine())) {
                if (stage1 == null && stage2 == null && stage3 == null) {
                    stage1 = "Заказ готов к отправке.";
                    System.out.println(stage1);
                    break;
                } else if (stage2 == null && stage3 == null) {
                    stage2 = "Заказ отправлен.";
                    System.out.println(stage2);
                    break;
                } else if (stage3 == null) {
                    stage3 = "Заказ доставлен!";
                    System.out.println(stage3);
                    break;
                }
            } else {
                System.out.println("Проверьте правильность ввода трек-номера! Или прекратите ввод (end)");
            }
        System.out.println(stage1);
    }

}

