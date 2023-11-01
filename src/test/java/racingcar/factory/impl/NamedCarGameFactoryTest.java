package racingcar.factory.impl;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            NamedCarGameFactory namedCarGameFactory = new NamedCarGameFactory("nero123,naro", 3);
            Assertions.fail();
            Game game = namedCarGameFactory.createGame();
            game.play();
        });
    }
}