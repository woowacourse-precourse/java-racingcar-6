package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> cars;
    private final int tryCount;

    public Game(List<String> carNames, int tryCount) {
        this.cars = createCars(carNames);
        this.tryCount = tryCount;
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void play() {
        for (int i = 0; i < tryCount; i++) {
            moveCars();
            System.out.println();
        }
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
            OutputController.printCarPosition(car);
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
