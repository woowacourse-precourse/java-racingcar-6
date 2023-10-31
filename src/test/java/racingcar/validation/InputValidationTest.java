package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidationTest {

    InputValidation inputValidation = new InputValidation();

    @DisplayName("자동차 이름을 쉼표 기준으로 구분하여 5자 초과인 경우 IllegalArgumentException 발생한다.")
    @Test
    void 자동차_이름을_쉼표_기준으로_구분하여_5자_초과인_경우() {
        //given
        String input = "tooomi";

        //when //then
        assertThatThrownBy(() -> {
            inputValidation.raiseErrorIfCarNameExceedsLimit(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @DisplayName("시도할 회수가 문자일 경우 `IllegalArgumentException` 발생시킨다.")
    @Test
    void 시도할_회수가_문자일_경우() {
        //given
        String input = "tooomi";

        //when //then
        assertThatThrownBy(() -> {
            inputValidation.raiseErrorIfAttemptCountIsInvalid(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("String out of numeric range");
    }

    @DisplayName("시도할 회수가 0보다 작을 경우 `IllegalArgumentException` 발생시킨다.")
    @Test
    void 시도할_회수가_0보다_작을_경우() {
        //given
        String input = "-1";

        //when //then
        assertThatThrownBy(() -> {
            inputValidation.raiseErrorIfAttemptCountIsInvalid(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("String out of integer range");
    }
}