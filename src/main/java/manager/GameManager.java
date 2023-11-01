package manager;

import custom_object.Car;

import utility.RandomNumberGenerator;

import java.util.List;

public class GameManager {
    private final List<Car> carList;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public GameManager(List<Car> carList) {
        this.carList = carList;
    }

    // 디미터의 법칙 위반.
    public void progressMatch() {
        for (Car car: carList) {
            car.tryMoving(randomNumberGenerator.generatingForCarTryMoving());
        }
    }

    public void outputCurrentPosition() {
        for (Car car: carList) {
            System.out.println(car.getName() + ":" + "-".repeat(car.getPosition()));
        }
    }
}
