package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.app.RacingGameConst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.app.RacingGameConst.*;

class RacingGameValidatorTest {

    @Test
    @DisplayName("자동차 이름들로 빈 문자열이 주어질 때 예외 발생")
    void carInputEmptyTest() {
        List<String> names = new ArrayList<>();
        assertThatThrownBy(() -> RacingGameValidator.validateCarNameInput(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAMES_EMPTY_ERROR_MESSAGE);

    }

    @Test
    @DisplayName("자동차 이름들 중 빈 문자열이 포함되어 있을 때 예외 발생")
    void carInputIncludeEmptyNameTest() {
        List<String> names = Arrays.asList("a", "", "c");
        assertThatThrownBy(() -> RacingGameValidator.validateCarNameInput(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAMES_INCLUDE_EMPTY_ERROR_MESSAGE);
    }
}