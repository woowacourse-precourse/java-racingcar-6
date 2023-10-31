package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @DisplayName("2개 미만의 이름을 입력하면 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"test", ""})
    void validateCarNamesSizeTest(String inputName) {
        List<String> names = Arrays.asList(inputName);

        assertThatThrownBy(() -> InputValidator.validateCarNamesSize(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.CAR_NAMES_UNDER_SIZE_ERROR_MESSAGE);
    }

    @DisplayName("5글자를 초과한 이름이면 예외처리")
    @Test
    void validateCarNameLengthTest() {
        List<String> names = Arrays.asList("test", "overNameTest1", "overNameTest2");

        assertThatThrownBy(() -> InputValidator.validateCarNameLength(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.CAR_NAME_LENGTH_OVER_ERROR_MESSAGE);
    }

    @DisplayName("공백 이름이 포함되어 있으면 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void validateBlankName(String blankName) {
        List<String> names = Arrays.asList("test1", blankName, "test2");

        assertThatThrownBy(() -> InputValidator.validateBlankName(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.BLANK_CAR_NAME_ERROR_MESSAGE);
    }

    @DisplayName("1회 미만의 시도 횟수이면 예외처리")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void validateMoveCountRangeTest(int moveCount) {
        assertThatThrownBy(() -> InputValidator.validateMoveCountRange(moveCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.UNDER_MIN_MOVE_COUNT_ERROR_MESSAGE);
    }
}