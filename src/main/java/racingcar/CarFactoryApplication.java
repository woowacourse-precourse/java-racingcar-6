package racingcar;

import racingcar.controller.CarFactoryController;
import racingcar.domain.Cars;
import racingcar.view.CarNamesInputView;

public class CarFactoryApplication {

    CarFactoryController carFactoryController;


    public CarFactoryApplication() {
        carFactoryController = new CarFactoryController();
    }

    public Cars produceCarsWithInput() {

        return carFactoryController.createRacingCars(CarNamesInputView.input());

    }



}
