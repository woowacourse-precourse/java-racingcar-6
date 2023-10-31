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
                .hasMessageContaining("경주에 참여할 자동차의 이름 수가 모자릅니다. 적어도 2개 이상의 이름을 입력해주세요.");
    }

    @DisplayName("5글자를 초과한 이름이면 예외처리")
    @Test
    void validateCarNameLengthTest() {
        List<String> names = Arrays.asList("test", "overNameTest1", "overNameTest2");

        assertThatThrownBy(() -> InputValidator.validateCarNameLength(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름이 5글자를 초과 했습니다. 5글자 이하의 이름으로 입력해주세요.");
    }

    @DisplayName("공백 이름이 포함되어 있으면 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void validateBlankName(String blankName) {
        List<String> names = Arrays.asList("test1", blankName, "test2");

        assertThatThrownBy(() -> InputValidator.validateBlankName(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름 중 공백으로만 이루어진 이름이 포함되어있습니다. 공백 이름은 입력하실 수 없습니다.");
    }

    @DisplayName("1회 미만의 시도 횟수이면 예외처리")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void validateMoveCountRangeTest(int moveCount) {
        assertThatThrownBy(() -> InputValidator.validateMoveCountRange(moveCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 시도 횟수보다 낮은 값을 입력하셨습니다. 최소 1회 이상의 시도 횟수를 입력해주세요.");
    }
}