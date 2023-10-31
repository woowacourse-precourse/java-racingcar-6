package racingcar;

import java.util.LinkedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validation.InputValidation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("유저 입력 테스트")
public class InputValidationTest {

    @DisplayName("이름 입력값 6자 이상 예외 테스트")
    @Test
    void name_over_6_len() {
        // given
        String input = "abcdef";
        LinkedHashMap<String, String> carListAnswer = new LinkedHashMap<>();

        // then
        assertThatThrownBy(
                () -> InputValidation.checkNameRight(input, carListAnswer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하의 이름만 가능합니다.");
    }

    @DisplayName("이름 입력값 중복 예외 테스트")
    @Test
    void name_duplicate() {
        // given
        String input = "woni";
        LinkedHashMap<String, String> carListAnswer = new LinkedHashMap<>();

        carListAnswer.put("woni", "");

        // then
        assertThatThrownBy(
                () -> InputValidation.checkNameRight(input, carListAnswer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름이 있습니다.");

    }

    @DisplayName("횟수 입력값에 문자 입력 시 예외 발생")
    @Test
    void count_not_integer() {
        // given
        String input = "121111111111111";

        // then
        assertThatThrownBy(
                () -> InputValidation.checkCountRight(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 숫자입니다.");
    }
}
