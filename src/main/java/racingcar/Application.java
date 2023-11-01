package racingcar;

import racingcar.domain.Game;
import racingcar.domain.GameMaker;

public class Application {
    public static void main(String[] args) {
        GameMaker maker = new GameMaker();
        Game manager = new Game(maker.cars, maker.totalRounds);
        manager.play();
    }
}
