package racingcar;

import racingcar.controller.Car;
import racingcar.controller.RacingGameController;
import racingcar.my_io.MyInput;
import racingcar.utils.CarNameValidator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Car car = new Car();
        CarNameValidator carNameValidator = new CarNameValidator();
        MyInput myInput = new MyInput();

        RacingGameController racingGameController = new RacingGameController(car, carNameValidator, myInput);
        racingGameController.startGame();
    }
}
