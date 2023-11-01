package racingcar.factory.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.game.Game;

class NamedCarGameFactoryTest {

    @Test
    void createGame() {
        NamedCarGameFactory namedCarGameFactory = new NamedCarGameFactory("nero,naro", 3);
        Game game = namedCarGameFactory.createGame();
        game.play();
    }

    @Test
    void createGameFail() {
        NamedCarGameFactory namedCarGameFactory = new NamedCarGameFactory("nero123,naro", 3);
        Assertions.fail();
        Game game = namedCarGameFactory.createGame();
        game.play();
    }
}