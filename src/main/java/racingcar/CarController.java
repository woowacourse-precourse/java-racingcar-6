package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    private final List<Car> cars;

    public CarController(String carNames) {
        this.cars = toList(carNames);
    }

    private List<Car> toList(String carNames) {
        List<Car> cars = new ArrayList<>();

        String[] name = carNames.split(",");
        for (String s : name) {
            cars.add(new Car(s));
        }

        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.movePosition();
        }

        printPositions();
    }

    private void printPositions() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");

            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }

            System.out.print("\n");
        }
    }
}
