package racingcar;

import java.util.List;
import java.util.ArrayList;

public class Race {
    private List<Car> cars = new ArrayList<>();
    private int count;

    public Race(String[] carNames, int count) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.count = count;
    }

    public void startRace() {
        for (int i = 0; i < count; i++) {
            System.out.println("시도 " + (i + 1));
            for (Car car : cars) {
                car.move();
                printStatus(car);
            }
            System.out.println();
        }
    }

    public void printStatus(Car car) {
        System.out.print(car.getName() + " : ");
        for (int j = 0; j < car.getPosition(); j++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public String getWinners() {
        int maxPosition = -1;
        StringBuilder winners = new StringBuilder();
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners = new StringBuilder(car.getName());
            } else if (car.getPosition() == maxPosition) {
                winners.append(", ").append(car.getName());
            }
        }
        return winners.toString();
    }
}
