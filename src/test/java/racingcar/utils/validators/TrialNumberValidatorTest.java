package racingcar.utils.validators;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.TrialNumber;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TrialNumberValidatorTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("Parameters")
    @DisplayName("시도 회수 검증")
    void checkTrialNumber(String testName, String trialNumber) {
        Assertions.assertThatThrownBy(() -> TrialNumberValidator.validateTrialNumber(trialNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> Parameters() {
        return Stream.of(
                Arguments.of("문자", "HotFriedChicken"),
                Arguments.of("특수 문자", "Hot+Hot"),
                Arguments.of("공백 포함", "1 2 3"),
                Arguments.of("소수", "0.6"),
                Arguments.of("음수", "-123"),
                Arguments.of("0테스트1", "0"),
                Arguments.of("0테스트2", "000"),
                Arguments.of("공백", " "),
                Arguments.of("빈 값", "")
        );
    }

    @Test
    @DisplayName("양의 정수 검증")
    void shouldReturnPositiveInteger() {
        String input = "123";
        TrialNumber trialNumber = new TrialNumber(input);
        int result = trialNumber.getTrialNumber();

        assertThat(result).isEqualTo(123);
    }
}