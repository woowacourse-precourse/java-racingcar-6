package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Car;

public class Printer {
    public static void printRace(ArrayList<Car> cars) {
        cars.forEach(car -> {
            System.out.printf("%s : ", car.getName());
            printDistance(car.getDistance());
        });
        System.out.println();
    }

    private static void printDistance(int distance) {
        IntStream.range(0, distance).forEach(i -> System.out.print("-"));
        System.out.println();
    }

}
