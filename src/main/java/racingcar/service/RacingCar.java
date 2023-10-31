package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class RacingCar {
    private final Car[] cars;
    private final int tryCount;

    public RacingCar(List<String> carNames, int tryCount) {
        this.tryCount = tryCount;
        this.cars = new Car[carNames.size()];
        for (int i = 0; i < carNames.size(); i++) {
            cars[i] = new Car(carNames.get(i));
        }
    }

    public void start() {
        for (int i = 0; i< tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            printResult();
            System.out.println();
        }
    }

    public void printResult() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public int maxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<String> Winners() {
        int maxPosition = maxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void printWinners(List<String> winners) {
        System.out.print("\n최종 우승자 : ");
        boolean firstWinner = true;
        for (String winner : winners) {
            if (!firstWinner) {
                System.out.print(", ");
            }
            System.out.print(winner);
            firstWinner = false;
        }
    }
}
