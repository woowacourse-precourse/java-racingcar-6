package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RacingGame {
    List<Car> racingCars = new ArrayList<Car>();

    RacingGame(String cars) {
        try {
            splitNames(cars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    void splitNames(String cars) {
        String[] names = cars.split(",");
        Arrays.stream(names).forEach(name -> {
            ExceptionString.exceptionCheckName(name);
            name = name.trim();
            racingCars.add(new Car(name));
        });
    }

    void printStep() {
        racingCars.stream().forEach(car -> System.out.println(car));
        System.out.println();
    }

    void executeStep() {
        racingCars.stream().forEach(car -> car.moveRandom());
    }

    void printResult() {
        racingCars.sort(Comparator.reverseOrder());
        Car victor = racingCars.get(0);
        System.out.print("최종 우승자 : " + victor.name);
        racingCars.stream()
                .filter(s -> s.distance == victor.distance && s != victor)
                .forEach(s -> System.out.print(", " + s.name));
    }

    void playGame(int step) {
        for(int i = 0; i < step; i++) {
            executeStep();
            printStep();
        }
        printResult();
    }
}
