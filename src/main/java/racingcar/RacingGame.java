package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class RacingGame {
    public ArrayList<Car> racingCars;
    String carNames;
    RacingGame(String carNames) {
        this.carNames = carNames;
        splitCarNames(carNames);
    }

    void splitCarNames(String cars) {
        this.racingCars = new ArrayList<Car>();
        String[] names = cars.split(",");
        try {
            Arrays.stream(names).forEach(name -> {
                InputException.exceptionCheckName(name);
                name = name.trim();
                racingCars.add(new Car(name));
            });
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            throw e;
        }
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
