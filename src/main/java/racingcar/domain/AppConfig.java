package racingcar.domain;

import racingcar.domain.car.controller.CarController;
import racingcar.domain.car.service.CarService;
import racingcar.domain.car.view.CarInputView;
import racingcar.domain.car.view.CarOutputView;

public class AppConfig {


    public static CarController carController() {
        return new CarController(new CarInputView(), new CarOutputView(), new CarService());
    }

}
