package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.pattern.RandomValueGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new RacingGameController(RandomValueGenerator.getInstance()).gameStart();

    }
}
