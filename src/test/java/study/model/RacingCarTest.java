package study.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

class RacingCarTest {

    @Test
    void test_전진조건() {
        // given
        RacingCar racingCar = new RacingCar("povi", () -> 4);

        // when
        racingCar.executeRound();
        int distance = racingCar.getDistance();

        // then
        assertThat(distance).isEqualTo(1);
    }

    @Test
    void test_정지조건() {
        // given
        RacingCar racingCar = new RacingCar("povi", () -> 3);

        // when
        racingCar.executeRound();
        int distance = racingCar.getDistance();

        // then
        assertThat(distance).isEqualTo(0);
    }

    @Test
    void test_정상적인경우() {
        // given
        RacingCar racingCar = new RacingCar("povi");

        // when
        for (int i = 0; i < 5; i++) {
            racingCar.executeRound();
        }
        int distance = racingCar.getDistance();

        // then
        assertThat(distance).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(5);
    }
}
