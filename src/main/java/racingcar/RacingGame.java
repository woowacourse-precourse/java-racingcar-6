package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RacingGame {
    List<Car> racingCars = new ArrayList<Car>();

    RacingGame(String cars) {
        String[] names = cars.split(",");
        for(String name : names) {
            racingCars.add(new Car(name));
        }
    }

    void printStep() {
        for(Car car : racingCars) {
            System.out.println(car);
        }
    }

    void executeStep() {
        for(Car car : racingCars) {
            car.moveRandom();
        }
    }

    void printResult() {
        racingCars.sort(Comparator.reverseOrder());
        Car victor = racingCars.get(0);
        System.out.print("최종 우승자 : " + victor.name);
        racingCars.stream()
                .filter(s -> s.distance == victor.distance && s != victor)
                .forEach(s -> System.out.print(", " + s.name));
    }
}
