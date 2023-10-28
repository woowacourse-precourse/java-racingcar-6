package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차 이름들을 받아서 자동차들을 생성한다.")
    void of() {
        Cars cars = Cars.of("pobi,crong,honux");

        assertThat(cars).isEqualTo(Cars.of("pobi,crong,honux"));
    }
}