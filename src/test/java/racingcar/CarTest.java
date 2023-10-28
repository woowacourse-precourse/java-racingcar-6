package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_생성_테스트() {
        Car car = new Car("pobi");
        Assertions.assertThat(car.getCarName())
                .isNotNull()
                .isEqualTo("pobi");
    }

    @Test
    void 자동차_전진_테스트() {
        Car car = new Car("pobi");
        car.plusMoveForward();

        Assertions.assertThat(1)
                .isEqualTo(car.getPosition());
    }
}
