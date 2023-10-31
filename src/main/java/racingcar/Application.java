package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RacingCars;
import racingcar.domain.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCars racingCars = new RacingCars(numberGenerator());
        RacingGameController racingGameController = new RacingGameController(racingCars);
        racingGameController.start();
    }

    private static NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }
}
