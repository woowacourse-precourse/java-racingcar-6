package racingcar;

import racingcar.game.Game;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        Game game = new Game();
        game.startGame(game.makeCarEntity());
    }
}
