package racingcar;

import racingcar.domain.CarManager;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new RacingGameManager(new CarManager(), new RacingGame()).start();
    }
}
