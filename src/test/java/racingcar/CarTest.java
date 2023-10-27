package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

class CarTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            true, 1
            false, 0
            """)
    void 엔진_결과에_따라_차를_움직일_수_있다(boolean result, int expected) {
        Car car = new Car(() -> result);

        car.moveForward();

        assertThat(car.currentPosition()).isEqualTo(expected);
    }
}
