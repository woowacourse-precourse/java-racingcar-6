package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차를_움직일_수_있다(int distance) {
        // given
        Car car = Car.createOnStart(() -> distance, "car");

        // when
        car.drive();

        // then
        assertThat(car.getPosition()).isEqualTo(distance);
    }
}
