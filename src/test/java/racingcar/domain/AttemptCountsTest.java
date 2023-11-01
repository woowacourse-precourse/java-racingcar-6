package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AttemptCountsTest {

    @DisplayName("시도 횟수가 1 이상 2억 이하의 수면 아니면 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "99", "200000000"})
    void validateAttemptCountsSuccessTest(String attempt) {
        assertThatCode(() -> AttemptCounts.from(attempt))
                .doesNotThrowAnyException();
    }

    @DisplayName("시도 횟수가 1 이상 2억 이하의 수가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideValidateAttemptCountsFailTestArguments")
    void validateAttemptCountsFailTest(String attempt, String message) {
        assertThatCode(() -> AttemptCounts.from(attempt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    static Stream<Arguments> provideValidateAttemptCountsFailTestArguments() {
        return Stream.of(
                arguments("-1", "시도 횟수는 1 이상 2억 이하의 숫자만 입력 가능합니다."),
                arguments("0", "시도 횟수는 1 이상 2억 이하의 숫자만 입력 가능합니다."),
                arguments("200000001", "시도 횟수는 1 이상 2억 이하의 숫자만 입력 가능합니다."),
                arguments("일부러", "입력값이 숫자가 아닙니다."),
                arguments("~!@#$%^&*()_+", "입력값이 숫자가 아닙니다."),
                arguments("fail", "입력값이 숫자가 아닙니다.")
        );
    }
}
