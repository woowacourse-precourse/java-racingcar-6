package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> cars;

    public RacingCars(List<String> carNames) {
        this.cars = new ArrayList<>();

        carNames.stream()
                .forEach(name -> this.cars.add(new RacingCar(name)));
    }

    public void attemptMove(int numberOfAttempts) {
        while (numberOfAttempts-- > 0) {
            attemptMoveEachCar();
            printCurrentDistanceEachCar();
            System.out.println();
        }
    }


    private void attemptMoveEachCar() {
        this.cars.stream()
                .forEach(racingCar -> {
                    racingCar.move();
                });
    }

    private void printCurrentDistanceEachCar() {
        this.cars.stream()
                .forEach(racingCar -> {
                    racingCar.printCurrentDistance();
                });
    }
}
