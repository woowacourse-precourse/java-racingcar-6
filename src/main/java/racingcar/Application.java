package racingcar;

import racingcar.domain.Player;
import racingcar.domain.RacingCarGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Player player = new Player();
        RacingCarGame racingCarGame = new RacingCarGame(player);
        racingCarGame.init();
    }
}
