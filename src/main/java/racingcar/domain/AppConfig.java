package racingcar.domain;

import racingcar.domain.car.controller.CarController;
import racingcar.domain.car.dao.CarRepository;
import racingcar.domain.car.service.CarService;
import racingcar.domain.car.view.CarInputView;
import racingcar.domain.car.view.CarOutputView;

public class AppConfig {


    public static CarController getController() {
        return new CarController(getCarInputView(), getCarOutputView(), getCarService());
    }

    private static CarService getCarService() {
        return new CarService(getCarRepository());
    }

    private static CarRepository getCarRepository() {
        return new CarRepository();
    }

    private static CarOutputView getCarOutputView() {
        return new CarOutputView();
    }

    private static CarInputView getCarInputView() {
        return new CarInputView();
    }

}
