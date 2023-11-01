package racingcar.validate;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.Application;

import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateTest extends NsTest {

    @Nested
    @DisplayName("IllegalArgumentException이 발생하는가?")
    class ExceptionHandler {
        @DisplayName("자동차 이름 오기입 시 예외 발생")
        @ParameterizedTest
        @MethodSource("provideInputForInvalidInputUsername")
        void invalidInputUsername(String input, String expectedMessage) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input, "1"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(expectedMessage)
            );
        }

        private static Stream<Arguments> provideInputForInvalidInputUsername() {
            return Stream.of(
                    Arguments.of("javajigi,aaa", "이름은 5자 이하로 입력해주세요."),
                    Arguments.of("aaa,javajigi", "이름은 5자 이하로 입력해주세요."),
                    Arguments.of("aaa, java", "자동차 이름은 공백으로 시작할 수 없습니다."),
                    Arguments.of("", "공란입니다. 이름을 입력해주세요."),
                    Arguments.of(",", "공란입니다. 이름을 입력해주세요."),
                    Arguments.of("aa,", "잘못된 형식의 입력입니다."),
                    Arguments.of(",java", "잘못된 형식의 입력입니다.")
            );
        }

        @DisplayName("시도 횟수 오기입 시 예외 발생")
        @ParameterizedTest
        @MethodSource("provideInputForInvalidInputNumberOfAttempts")
        void invalidInputNumberOfAttempts(String input, String expectedMessage) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,java", input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(expectedMessage)
            );
        }

        private static Stream<Arguments> provideInputForInvalidInputNumberOfAttempts() {
            return Stream.of(
                    Arguments.of("0", "1 이상의 10억 이하의 숫자를 입력해주세요."),
                    Arguments.of("-1", "1 이상의 10억 이하의 숫자를 입력해주세요."),
                    Arguments.of("aa", "숫자를 입력해주세요."),
                    Arguments.of("?", "숫자를 입력해주세요."),
                    Arguments.of("&", "숫자를 입력해주세요.")
            );
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
