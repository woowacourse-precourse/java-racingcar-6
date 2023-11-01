package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class Printer {
    public static void printRace(List<Car> cars) {
        cars.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinner(Car winner, List<Car> cars) {
        System.out.print("최종 우승자 : ");
        winner.printName(cars.stream().filter(car -> car.equals(winner)).toList());
    }

}
