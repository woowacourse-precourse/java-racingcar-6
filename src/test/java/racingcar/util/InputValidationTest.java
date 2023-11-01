package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidationTest {
    @Test
    @DisplayName("성공 : 자동차의 입력 값이 유효할 경우")
    void validateInputCarForSuccess() {
        //given
        String cars = "pobi,woni,jun";

        // when, then
        assertThatCode(() -> {
            InputValidation.validateEmptyInput(cars);
            InputValidation.validateCommaSeparatedInput(cars);
            InputValidation.validateInputLength(cars);
            InputValidation.validateDuplicateValues(cars);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("실패 : 자동차의 입력 값이 null 이거나 빈 문자열일 경우")
    void validateEmptyInputForFailure(String cars) {
        // when, then
        assertThatThrownBy(() -> InputValidation.validateEmptyInput(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni/jun", "pobi,woni jun", "pobi,woni.jun", "pobi-woni,jun", "pobi_woni,jun"})
    @DisplayName("실패 : 자동차의 입력 값이 쉼표로 구분되지 않을 경우")
    void validateCommaSeparatedInputForFailure(String cars) {
        // when, then
        assertThatThrownBy(() -> InputValidation.validateCommaSeparatedInput(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "abc,abcdef"})
    @DisplayName("실패 : 자동차 이름의 길이가 5자 초과일 경우")
    void validateInputLengthForFailure(String cars) {
        // when, then
        assertThatThrownBy(() -> InputValidation.validateInputLength(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실패 : 자동차 이름이 중복될 경우")
    void validateDuplicateValuesForFailure() {
        //given
        String cars = "pobi,pobi,woni";

        // when, then
        assertThatThrownBy(() -> InputValidation.validateDuplicateValues(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("성공 : 반복 횟수 입력 값이 유효할 경우")
    void validateInputExecutionForSuccess() {
        // given
        int attemptCount = 5;

        // when, then
        assertThatCode(() -> InputValidation.validateAttemptCount(attemptCount))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 11})
    @DisplayName("실패 : 시도 횟수가 1 미만이거나 10 초과의 수를 입력할 경우")
    void validateAttemptCountForFailure(int attemptCount) {
        // when, then
        assertThatThrownBy(() -> InputValidation.validateAttemptCount(attemptCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
