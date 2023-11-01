package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    @Test
    @DisplayName("자동차 이름을 입력받고 쉼표(,) 기준으로 구분하여 List로 변환한다.")
    void validateCarNames() {
        // given
        String inputCarNames = "test1,test2";

        // when
        List<String> actual = InputValidator.validateCarNames(inputCarNames);

        // then
        List<String> expected = List.of("test1", "test2");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 이름은 5글자를 초과할 수 없다.")
    void validateCarNames_EXCEED_MAX_LENGTH() {
        // given
        String inputCarNames = "testtest";

        // when, then
        assertThatThrownBy(() -> InputValidator.validateCarNames(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 시도 횟수를 문자열로 입력받고 정수형으로 변환한다.")
    void validateTryCountIsNumber() {
        // given
        String inputTryCount = "5";

        // when
        int actual = InputValidator.validateTryCountIsNumber(inputTryCount);

        // then
        int expected = 5;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("게임 시도 횟수는 반드시 숫자만 입력받을 수 있다.")
    void validateTryCountIsNotNumber() {
        // given
        String inputTryCount = "a";

        // when
        assertThatThrownBy(() -> InputValidator.validateTryCountIsNumber(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}