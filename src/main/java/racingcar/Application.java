package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.Car;
import racingcar.utils.CarValidator;
import racingcar.view.RacingCarView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Car car = new Car();
        CarValidator carValidator = new CarValidator();
        RacingCarView racingCarView = new RacingCarView();

        RacingCarController racingCarController = new RacingCarController(car, carValidator, racingCarView);

        racingCarController.start();
    }
}
