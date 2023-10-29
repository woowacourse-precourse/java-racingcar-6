package racingcar.io;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("입력값 검증 클래스의 객체에")
class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Nested
    @DisplayName("자동차 이름 입력값 검증 요청시")
    class ValidateRacingCarNames {

        @Test
        @DisplayName("정상적인 입력값인 경우 예외를 던지지 않는가")
        void properInput() {
            // given
            // when
            // then
            assertThatNoException()
                    .isThrownBy(() -> inputValidator.validateRacingCarNames("a 가,df2"));
        }

        @Test
        @DisplayName("입력값이 콤마로 시작하면 예외를 던지는가")
        void startsWithComma() {
            // given
            // when
            // then
            assertThatThrownBy(() -> inputValidator.validateRacingCarNames(",ac,ef"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력값이 콤마로 끝나면 예외를 던지는가")
        void endsWithComma() {
            // given
            // when
            // then
            assertThatThrownBy(() -> inputValidator.validateRacingCarNames("ac,ef,"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력값이 콤마를 연속적으로 가지면 예외를 던지는가")
        void twoComma() {
            // given
            // when
            // then
            assertThatThrownBy(() -> inputValidator.validateRacingCarNames("ac,,ef"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("시도 횟수 입력값 검증 요청시")
    class validateTryCount {

        @Test
        @DisplayName("숫자인 경우 예외를 던지지 않는가")
        void numeric() {
            // given
            // when
            // then
            assertThatNoException().isThrownBy(() -> inputValidator.validateTryCount("1"));
        }

        @Test
        @DisplayName("입력값이 콤마를 연속적으로 가지면 예외를 던지는가")
        void notNumeric() {
            // given
            // when
            // then
            assertThatThrownBy(() -> inputValidator.validateTryCount("a"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
