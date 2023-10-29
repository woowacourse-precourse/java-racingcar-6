package racingcar;

import racingcar.controller.PlayRacingGame;
import racingcar.controller.PlayRacingGameImpl;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PlayRacingGame playRacingGame = new PlayRacingGameImpl();
        playRacingGame.playRacingGame();
    }
}
