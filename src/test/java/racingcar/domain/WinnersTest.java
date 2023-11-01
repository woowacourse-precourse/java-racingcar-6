package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinnersTest {
    private static final String CORRECT_CARS_NAME = "poby,woni";

    @Test
    void 우승자를_정상적으로_생성한다() {
        // given
        Cars cars = Cars.of(CORRECT_CARS_NAME);

        // when
        Winners winners = Winners.of(cars);

        // then
        Assertions.assertThat(winners).isNotNull();
    }

    @Test
    void 형식에_맞게_우승자를_출력한다() {
        // given
        Cars cars = Cars.of(CORRECT_CARS_NAME);
        String expected = "최종 우승자 : poby, woni";
        // when
        Winners winners = Winners.of(cars);

        // then
        Assertions.assertThat(winners.toString()).isEqualTo(expected);
    }
}
