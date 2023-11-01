package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.Rounds;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new Cars(), new Rounds());
        game.start();
    }
}
