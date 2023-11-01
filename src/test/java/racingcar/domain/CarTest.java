package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class CarTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            a,
            12345
            """)
    void 유효한_이름이면_정상_생성(String validName) {
        Car car = new Car(validName, 0, () -> true);

        assertThat(car.getName()).isEqualTo(validName);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            '',
            ' ',
            '1 ',
            ' 1',
            123456
            """)
    void 이름이_유효하지_않으면_예외가_발생한다(String invalidName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(invalidName, 0, () -> true));
    }

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
