package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(String carNames) {
        String[] names = carNames.split(",");
        cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
    }

    public void start(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void printRaceResults() {
        for (Car car : cars) {
            String result = car.getName() + " : " + "-".repeat(car.getPosition());
            System.out.println(result);
        }
    }

    public String getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return String.join(", ", winners);
    }
}
