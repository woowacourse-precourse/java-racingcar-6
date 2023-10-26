package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.service.RacingGameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RacingGameService racingGameService = new RacingGameService();
        RacingCarGame racingCarGame = new RacingCarGame(racingGameService);
        racingCarGame.run();
    }
}
