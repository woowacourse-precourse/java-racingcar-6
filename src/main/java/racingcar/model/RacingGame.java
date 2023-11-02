package racingcar.model;

import racingcar.exception.InputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class RacingGame {
    public ArrayList<Car> racingCars;
    private String carNames;

    public RacingGame(String carNames) {
        this.carNames = carNames;
        splitCarNames(carNames);
    }

    private void splitCarNames(String cars) {
        this.racingCars = new ArrayList<Car>();
        String[] names = cars.split(",");
        try {
            Arrays.stream(names).forEach(name -> {
                InputException.exceptionCheckName(name, racingCars);
                name = name.trim();
                racingCars.add(new Car(name));
            });
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    private void printStep() {
        racingCars.stream().forEach(car -> System.out.println(car));
        System.out.println();
    }

    private void executeStep() {
        racingCars.stream().forEach(car -> car.moveRandom());
    }

    private void printResult() {
        racingCars.sort(Comparator.reverseOrder());
        Car victor = racingCars.get(0);
        System.out.print("최종 우승자 : " + victor.getName());
        racingCars.stream()
                .filter(s -> s.getDistance() == victor.getDistance() && s != victor)
                .forEach(s -> System.out.print(", " + s.getName()));
    }

    public void playGame(int step) {
        for (int i = 0; i < step; i++) {
            executeStep();
            printStep();
        }
        printResult();
    }
}
