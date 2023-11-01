package racingcar;

import racingcar.service.CarService;

public class Application {
    private static final CarService carService = new CarService();
    public static void main(String[] args) {
        carService.start();
    }
}
