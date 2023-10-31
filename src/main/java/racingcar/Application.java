package racingcar;

import racingcar.gameplayer.GamePlayer;

public class Application {
    public static void main(String[] args) {
        GamePlayer gamePlayer = new GamePlayer();
        gamePlayer.startGame();
    }
}
