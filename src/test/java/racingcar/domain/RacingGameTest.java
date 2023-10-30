package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    public static final int TEST_REPEAT = 5;
    private RacingGame racingGame;

    @BeforeEach
    public void init() {
        List<Car> cars = List.of(
                new Car("pobi", new TestNumberGenerator(5)),
                new Car("json", new TestNumberGenerator(3)),
                new Car("hun", new TestNumberGenerator(9)));
        racingGame = new RacingGame(cars, TEST_REPEAT);
    }

    @Test
    public void 레이싱을_한다() {

        racingGame.doRace();

        assertThat(racingGame.getStatus()).filteredOn(car -> car.getLocation() != 0).hasSize(2);
    }

    @Test
    public void 게임이_끝나면_True를_반환() {

        for (int i = 0; i < TEST_REPEAT; i++) {
            racingGame.doRace();
        }

        assertThat(racingGame.isEnd()).isTrue();
    }

}
