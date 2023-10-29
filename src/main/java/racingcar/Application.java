package racingcar;

import racingcar.domain.Cars;

public class Application {
    public static void main(String[] args) {
        CarFactoryApplication carFactoryApplication = new CarFactoryApplication();
        CarRacingApplication carRacingApplication = new CarRacingApplication();

        Cars cars = carFactoryApplication.produceCarsWithInput();

        carRacingApplication.runWith(cars);



    }
}
