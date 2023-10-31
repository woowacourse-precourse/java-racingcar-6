package racingcar;

import racingcar.domain.Game;

public class Application {

    public static void main(String[] args) {
        Game game = new Game();
        game.initialize();
        game.play();
        game.getWinners();
    }
}
