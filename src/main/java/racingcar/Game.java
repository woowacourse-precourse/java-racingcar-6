package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    User user = new User();

    public List<Car> createCars(List<String> carNames, Long repeat) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void printDash(Long totalMovements) {
        for (int i = 0; i < totalMovements; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void eachRound(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward();
            System.out.print(car.carName + ": ");
            printDash(car.getTotalMovements());
        }
    }


}
