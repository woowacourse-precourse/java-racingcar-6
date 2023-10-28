package racingcar;

import racingcar.controller.InputManager;
import racingcar.domain.Car;

public class Application {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();

        System.out.println(inputManager.inputCarName());

    }
}
