package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Car> cars;
    private CarControlManager controlManager;

    private GameManager() {
        this.cars = new ArrayList<>();
        this.controlManager = new CarControlManager();
    }

    public static GameManager create() {
        return new GameManager();
    }

    public void addCar(String name) {
        Car car = new Car(name);
        car.setCarName(name);
        cars.add(car);
    }

    public void moveAllCars() {
        for (Car car : cars) {
            controlManager.moveFowardCar(car);
        }
    }

    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getCarName());
        }
        return carNames;
    }

    public List<Integer> getCarPositions() {
        List<Integer> carPositions = new ArrayList<>();
        for (Car car : cars) {
            carPositions.add(car.getCarCurrentPosition());
        }
        return carPositions;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();

        for (Car car : cars) {
            if (car.getCarCurrentPosition() == maxPosition) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = -1;
        for (Car car : cars) {
            int currentPosition = car.getCarCurrentPosition();
            if (currentPosition > maxPosition) {
                maxPosition = currentPosition;
            }
        }
        return maxPosition;
    }
}
