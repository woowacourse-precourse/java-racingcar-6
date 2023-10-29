package racingcar;

import static racingcar.config.Configuration.game;

public class Application {
    public static void main(String[] args) {
        Game game = game();
        game.play();
    }
}
