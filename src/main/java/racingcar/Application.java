package racingcar;

import racingcar.domain.RacingCars;

public class Application {
    public static void main(String[] args) {
        CarFactoryApplication carFactoryApplication = new CarFactoryApplication();
        CarRacingApplication carRacingApplication = new CarRacingApplication();

        RacingCars cars = carFactoryApplication.produceCarsWithInput();

        carRacingApplication.runWith(cars);


    }
}
