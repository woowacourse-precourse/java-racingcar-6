package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void 레이싱_게임_생성() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));
        int rounds = 5;
        RacingGame racingGame = new RacingGame(cars, rounds);

        assertNotNull(racingGame);
    }

}