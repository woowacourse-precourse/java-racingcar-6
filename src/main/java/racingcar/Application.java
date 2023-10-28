package racingcar;

import racingcar.controller.GameManager;
import racingcar.controller.InputManager;
import racingcar.domain.Car;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        GameManager gameManager = new GameManager();

        List<Car> cars = inputManager.inputCarName();
        System.out.println(cars);
        System.out.println(inputManager.inputRepeat());

        gameManager.checkMovePossible(cars.get(0));
        System.out.println(cars.get(0).getDistance());
    }
}
