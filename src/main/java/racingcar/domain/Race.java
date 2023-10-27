package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int moveCount;

    public Race(List<String> carNames, int moveCount) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.moveCount = moveCount;
    }

    private void moveCar() {
        for (Car car : cars) {
            car.moveForward();
            Output.printCar(car);
        }
        System.out.println();
    }

    public void start() {
        System.out.println("\n실행결과");
        for (int i = 0; i < moveCount; ++i) {
            moveCar();
        }
    }
}
