package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarGameTest {
    @Test
    @DisplayName("우승자 판별")
    void 가장_많이_전진한_자동차_목록_저장() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("dami"));
        cars.add(new Car("dayo"));
        cars.add(new Car("pobi"));
        cars.add(new Car("nabi"));
        RacingCarGame racingCarGame = new RacingCarGame();

        assertRandomNumberInRangeTest(() -> {
            for (Car car : cars) {
                car.moveOrStop();
            }
        }, 1, 2, 4, 4);

        // when
        List<Car> winners = racingCarGame.findWinner(cars);
        // then
        assertThat(winners).contains(cars.get(2), cars.get(3));
    }
}
