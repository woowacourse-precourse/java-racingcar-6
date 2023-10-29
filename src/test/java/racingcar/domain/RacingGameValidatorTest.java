package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static racingcar.app.RacingGameConst.*;

class RacingGameValidatorTest {

    @Test
    @DisplayName("자동차 이름들로 빈 이름이 주어질 때 예외 발생")
    void test_CarNameInputEmpty() {
        List<String> names = new ArrayList<>();
        assertThatThrownBy(() -> RacingGameValidator.validateCarNameInput(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAMES_EMPTY_MESSAGE);

    }

    @Test
    @DisplayName("자동차 이름들 중 빈 이름이 포함되어 있을 때 예외 발생")
    void test_CarNamesIncludeEmpty() {
        List<String> names = Arrays.asList("a", "", "c");
        assertThatThrownBy(() -> RacingGameValidator.validateCarNameInput(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAMES_INCLUDE_EMPTY_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름들 중 중복된 이름이 포함되어 있을 때 예외 발생")
    void test_CarNamesDuplicate() {
        List<String> names = Arrays.asList("a", "a", "c");
        assertThatThrownBy(() -> RacingGameValidator.validateCarNameInput(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAMES_DUPLICATE_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름이 특정 길이를 넘어설 때 예외발생")
    void test_CarNameOverLength() {
        List<String> names = Arrays.asList("a", "b", "thisnameistoolongforaracecar");
        assertThatThrownBy(() -> RacingGameValidator.validateCarNameInput(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAMES_OVER_LENGTH_MESSAGE);
    }

    @Test
    @DisplayName("경기 횟수로 숫자가 입력되지 않을 예외발생")
    void test_TrialInputIsNumber() {
        assertThatThrownBy(() -> RacingGameValidator.validateTrial("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TRIAL_NOT_NUMBER_MESSAGE);
    }

    @Test
    @DisplayName("입력된 경기 횟수가 최솟값보다 작을 때 예외발생")
    void test_TrialInputSmallerThanMinimum() {
        assertThatThrownBy(() -> RacingGameValidator.validateTrial("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TRIAL_SMALLER_THAN_MINIMUM);

        assertThatThrownBy(() -> RacingGameValidator.validateTrial("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TRIAL_SMALLER_THAN_MINIMUM);
    }

}