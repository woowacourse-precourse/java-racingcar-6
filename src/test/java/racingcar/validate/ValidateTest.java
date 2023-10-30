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
                    Arguments.of("0", "1 이상의 숫자를 입력해주세요."),
                    Arguments.of("-1", "1 이상의 숫자를 입력해주세요."),
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
