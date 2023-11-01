package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.Referee;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Referee referee = new Referee();
        RacingGame racingGame = new RacingGame(referee);
        racingGame.play();
    }
}