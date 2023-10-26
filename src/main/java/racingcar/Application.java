package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.service.CarService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        CarService carService = new CarService();
        RacingCarGame racingCarGame = new RacingCarGame(carService);
        racingCarGame.run();
    }
}
