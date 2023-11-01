package racingcar.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingCarTest {
    RacingCar racingCar = new RacingCar("test");

    @Test
    void 자동차이름_가져오기() {
        String carName = racingCar.getCarName();

        assertThat(carName).isEqualTo("test");
    }

    @Test
    void 전진_확인() {
        racingCar.plusProgress();
        racingCar.plusProgress();
        String progress = racingCar.getProgress();

        assertThat(progress).isEqualTo("--");
    }
}
