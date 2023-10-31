package view;

import java.util.List;
import service.Car;
import util.ProgressMessage;
import service.Cars;

public class MessagePrinter {
    static ProgressMessage start = ProgressMessage.START;
    static ProgressMessage inputTimes = ProgressMessage.INPUT_TIMES;
    static ProgressMessage result = ProgressMessage.RESULT;
    static ProgressMessage winner = ProgressMessage.WINNER;

    public static void start() {
        System.out.println(start.getMessage());
    }

    public static void inputTimes() {
        System.out.println(inputTimes.getMessage());
    }

    public static void result() {
        System.out.println(result.getMessage());
    }

    public static void winner(List<String> name) {
        System.out.print(winner.getMessage());

        System.out.println(String.join(", ", name));
    }

    public static void racing(Cars cars){
        List<Car> car = cars.car();
        car.forEach(i -> {
            name(i);
            distance(i);
        });
        System.out.println();
    }

    public static void name(Car car){
        System.out.print(car.getName() + " : ");
    }

    public static void distance(Car car){
        for (int distance = 0; distance < car.getDistance(); distance++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
