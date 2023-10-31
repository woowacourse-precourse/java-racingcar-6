package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {

    @Test
    void 이름으로_자동차_생성() {
        String carName = "poby";
        RacingCar car = new RacingCar(carName);

        assertThat(car).isNotNull();
    }

    @Test
    void 이름이_5글자가_넘으면_오류() {
        String carName = "name_length_over_5";

        assertThatThrownBy(() -> new RacingCar(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}