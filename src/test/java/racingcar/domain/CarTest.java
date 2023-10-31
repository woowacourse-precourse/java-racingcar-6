package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class CarTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            false, 0
            false, 0
            true, 1
            """)
    void 엔진_결과에_따라_차를_움직일_수_있다(boolean engineResult, int expected) {
        Car car = new Car("name", 0, () -> engineResult);

        car.moveForward();

        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
