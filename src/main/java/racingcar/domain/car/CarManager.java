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

    public void moveAndShowResult() {
        move();
        showResult();
    }
    private void move() {
        cars.forEach(Car::move);
    }

    private void showResult() {
        cars.forEach(Car::showCar);
        addBlank();
    }

    private void addBlank() {
        System.out.println();
    }

    public void showVictory() {
        victoryManager.showVictory(cars);
    }

}
