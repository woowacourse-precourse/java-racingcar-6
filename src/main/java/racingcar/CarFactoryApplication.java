package racingcar;

import racingcar.controller.CarFactoryController;
import racingcar.domain.RacingCars;
import racingcar.view.CarNamesInputView;

public class CarFactoryApplication {

    CarFactoryController carFactoryController;


    public CarFactoryApplication() {
        carFactoryController = new CarFactoryController();
    }

    public RacingCars produceCarsWithInput() {

        return carFactoryController.createRacingCars(CarNamesInputView.input());

    }


}
