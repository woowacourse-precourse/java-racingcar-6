package racingcar;

import java.util.*;

public class Race {
    private List<Car> cars;
    private int rounds;

    public Race(String[] carNames, int rounds) {
        this.rounds = rounds;
        this.cars = new ArrayList<>();

        for (String name : carNames) {
            this.cars.add(new Car(name));
        }
    }

    public void start() {
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                car.move();
            }
            printCurrentPositions();
        }
        printWinners();
    }

    private void printCurrentPositions() {
        for (Car car : cars) {
            car.printPosition();
        }
        System.out.println();
    }

    private void printWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
