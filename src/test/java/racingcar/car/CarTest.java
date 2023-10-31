package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차를_생성한다() {
        // given
        Car carA = new Car(new CarName("carA"), new Position(0));

        // then
        Assertions.assertThat(carA).isEqualTo(new Car(new CarName("carA"), new Position(0)));
    }
}
