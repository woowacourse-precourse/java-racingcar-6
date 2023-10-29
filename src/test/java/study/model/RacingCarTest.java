package study.model;

import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void test_정상적인경우() {
        // given
        RacingCar racingCar = new RacingCar();

        // when
        for (int i = 0; i < 5; i++) {
            racingCar.excuteRound();
        }
        int distance = racingCar.getDistance();

        // then
        assertThat(distance).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(5);
    }
}