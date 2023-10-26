package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @Test
    @DisplayName("자동차 경주를 진행할 수 있다.")
    void race() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        RacingGame racingGame = new RacingGame(cars, 1);

        racingGame.race(() -> 4);

        assertThat(cars).containsExactly(
                new Car("pobi", 1),
                new Car("woni", 1),
                new Car("jun", 1));
    }
}