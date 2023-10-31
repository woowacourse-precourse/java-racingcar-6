package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Car;

public class Printer {
    public static void printRace(List<Car> cars) {
        cars.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winners));
    }

}
