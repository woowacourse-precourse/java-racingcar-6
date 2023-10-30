package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"melon", "apple"})
    void 주어진_이름을_갖는_위치_0인_객체가_생성된다(String name) {
        Car car = Car.from(name);

        assertThat(car.nameValue()).isEqualTo(name);
        assertThat(car.positionValue()).isZero();
    }
}
