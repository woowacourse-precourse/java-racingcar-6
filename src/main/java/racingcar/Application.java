package racingcar;

import racingcar.car.Car;
import racingcar.game.Game;
import racingcar.round.Round;

import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        Game game = new Game();
        game.startGame(game.makeCarEntity());
    }
}
