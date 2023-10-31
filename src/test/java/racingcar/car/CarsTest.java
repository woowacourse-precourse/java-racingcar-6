package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 자동차들을_생성한다() {
        // given
        Cars cars = new Cars("A,B,C");

        // then
        Assertions.assertThat(cars).isEqualTo(new Cars("A,B,C"));
    }
}
