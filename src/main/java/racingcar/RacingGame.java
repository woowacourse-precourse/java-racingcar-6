package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private InputHandler inputHandler = new InputHandler();
    private List<Car> carList = new ArrayList<>();
    private int count;
    public void play() {
        initializeGame();
        for (int i = 0; i < count; i++) {
            moveAllCar(carList);
        }
        announceWinner();
    }
    private void initializeGame() {
        carList = registCarList(inputHandler.inputCarName());
        count = inputHandler.inputMatchCount();
    }

    private List<Car> registCarList(List<String> carNameList) {
        List<Car> cars = new ArrayList<>();
        for (String name: carNameList) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private void moveAllCar(List<Car> cars) {
        for (Car car: cars) {
            car.move();
        }
    }

    private static void announceWinner() {}

}
