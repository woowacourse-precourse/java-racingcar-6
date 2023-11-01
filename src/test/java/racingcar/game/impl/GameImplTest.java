package racingcar.game.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.impl.CarImpl;
import racingcar.game.Game;

class GameImplTest {

    @Test
    void play() {
        Car ne = new CarImpl("네로");
        Car na = new CarImpl("나로");
        final Game game = new GameImpl(
                List.of(ne, na), 3
        );
        game.play();
        System.out.println(na.getMovedDistance());
        System.out.println(ne.getMovedDistance());
        Assertions.assertNotEquals(4, na.getMovedDistance());
        Assertions.assertNotEquals(4, ne.getMovedDistance());
    }
}