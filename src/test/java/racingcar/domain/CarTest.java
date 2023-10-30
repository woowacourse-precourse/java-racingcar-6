package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class CarTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            1, 0
            3, 0
            4, 1
            """)
    void 제공받은_숫자에_따라_차를_움직일_수_있다(int suppliedInt, int expected) {
        Car car = new Car("car1", () -> suppliedInt);

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
            Car car = new Car(validName);

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
                    .isThrownBy(() -> new Car(invalidName));
        }
    }
}
