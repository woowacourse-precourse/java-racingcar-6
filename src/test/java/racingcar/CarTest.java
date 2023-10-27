package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

class CarTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            true, 1
            false, 0
            """)
    void 엔진_결과에_따라_차를_움직일_수_있다(boolean engineResult, int expected) {
        Car car = createCarOf(engineResult);

        car.moveForward();

        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @Nested
    class 생성_테스트 {
        @ParameterizedTest
        @CsvSource(textBlock = """
                a,
                12345
                """)
        void 유효한_이름이면_정상_생성(String validName) {
            Car car = createCarOf(validName);

            assertThat(car.getName()).isEqualTo(validName);
        }

        @ParameterizedTest
        @CsvSource(textBlock = """
                '',
                ' ',
                123456
                """)
        void 이름이_유효하지_않으면_예외가_발생한다(String invalidName) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> createCarOf(invalidName));
        }
    }

    private static Car createCarOf(boolean engineResult) {
        return new Car("testCar", () -> engineResult);
    }

    private static Car createCarOf(String name) {
        return new Car(name, () -> true);
    }
}
