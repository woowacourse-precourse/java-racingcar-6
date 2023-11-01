package racingcar;

import racingcar.gameplayer.GamePlayer;
import racingcar.service.GameService;
import racingcar.service.IoService;

public class Application {
    public static void main(String[] args) {
        GamePlayer gamePlayer = new GamePlayer();
        gamePlayer.startGame();
    }
}
