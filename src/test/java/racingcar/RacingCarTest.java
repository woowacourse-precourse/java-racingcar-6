package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    void 랜덤값이_4이상이면_전진한다() {
        RacingCar racingCar = new RacingCar("rc");
        assertThat(racingCar.getScore()).isEqualTo(0);

        racingCar.move(4);
        assertThat(racingCar.getScore()).isEqualTo(1);
    }
    @Test
    void 랜덤값이_4미만이면_멈춘다() {
        RacingCar racingCar = new RacingCar("rc");
        assertThat(racingCar.getScore()).isEqualTo(0);

        racingCar.move(3);
        assertThat(racingCar.getScore()).isEqualTo(0);
    }
}
