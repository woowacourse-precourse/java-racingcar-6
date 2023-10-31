package racingcar.checker;


import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Checker;

public class CheckerTest {

    @Test
    void 승리한_사람() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));

        cars.get(0).goStraight();

        List<Car> winners = Checker.checkWinners(cars);
        assertThat(winners).hasSize(1);

        List<String> winnerNames = winners.stream().map(car -> car.getName()).collect(Collectors.toList());
        assertThat(winnerNames).containsExactly("pobi");
    }

    @Test
    void 승리한_사람들() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));

        List<Car> winners = Checker.checkWinners(cars);
        assertThat(winners).hasSize(3);

        List<String> winnerNames = winners.stream().map(car -> car.getName()).collect(Collectors.toList());
        assertThat(winnerNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 값이_4_이상일_때_확인() {
        int num = 4;

        assertThat(Checker.checkAtLest4(num)).isEqualTo(true);
    }

    @Test
    void 값이_4_이하일_때_확인() {
        int num = 0;

        assertThat(Checker.checkAtLest4(num)).isEqualTo(false);
    }

    @Test
    void 값이_음수일_때_확인() {
        int num = -1;

        assertThatThrownBy(() -> Checker.checkAtLest4(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("불가능한 값이 들어왔습니다.");
    }

    @Test
    void 값이_10_이상일_때_확인() {
        int num = 10;

        assertThatThrownBy(() -> Checker.checkAtLest4(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("불가능한 값이 들어왔습니다.");
    }
}
