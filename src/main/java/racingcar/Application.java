package racingcar;

import racingcar.controller.GamePlayer;
import racingcar.controller.RacingCarPlayer;

public class Application {
    public static void main(String[] args) {
        GamePlayer gamePlayer = new RacingCarPlayer();
        gamePlayer.run();
    }
}
