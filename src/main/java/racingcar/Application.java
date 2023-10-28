package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.service.RacingGameService;
import racingcar.util.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RacingGameService racingGameService = new RacingGameService(randomNumberGenerator);
        RacingCarGame racingCarGame = new RacingCarGame(racingGameService);
        racingCarGame.run();
    }
}
