package racingcar.domain.car;

import java.util.List;
import racingcar.domain.victory.VictoryManager;

public class CarManager {
    private static final int MAX_CAR_COUNT = 5;
    private List<Car> cars;
    private final CarFactory carFactory;
    private final VictoryManager victoryManager;

    public CarManager(CarFactory carFactory, VictoryManager victoryManager) {
        this.carFactory = carFactory;
        this.victoryManager = victoryManager;
    }

    public void makeCar() {
        cars = carFactory.createCars();
    }

    public void moveAndShowProgress() {
        move();
        showProgress();
    }
    private void move() {
        cars.forEach(Car::move);
    }

    private void showProgress() {
        System.out.println(makeProgress());
    }

    private String makeProgress() {
        StringBuilder result = new StringBuilder();
        cars.forEach(car -> result.append(car.toString()).append("\n"));
        return result.toString();
    }

    public void showVictory() {
        victoryManager.showVictory(cars);
    }

}
