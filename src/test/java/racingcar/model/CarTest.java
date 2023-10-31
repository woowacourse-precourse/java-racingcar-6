package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 이름_검증_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("너무긴이름"))
                .withMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 초기_위치_테스트() {
        Car car = new Car("Test");
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
