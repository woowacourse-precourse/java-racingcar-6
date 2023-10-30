package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void 자동차의_이름이_5자를_넘은_경우_예외_처리() {
        String input = "abcdef";

        assertThatThrownBy(() -> Validator.validateAvailableLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("5자 이하로 입력해야 합니다.");
    }

    @Test
    void 자동차의_이름이_공백으로_이루어진_경우_예외_처리() {
        String input = "";

        assertThatThrownBy(() -> Validator.validateIsBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백은 사용할 수 없는 입력입니다.");
    }

    @Test
    void 자동차의_이름이_중복되는_경우_예외_처리() {
        List<String> input = List.of("pobi", "pobi", "jun");

        assertThatThrownBy(() -> Validator.validateIsDuplicate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않게 입력해야 합니다.");
    }

    @Test
    void 시도할_횟수에_숫자가_아닌_입력시_예외_처리() {
        String input = "abc";

        assertThatThrownBy(() -> Validator.validateIsNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력할 수 있습니다.");
    }

    @Test
    void 시도할_횟수에_공백_입력시_예외_처리() {
        String input = "";

        assertThatThrownBy(() -> Validator.validateIsBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백은 사용할 수 없는 입력입니다.");
    }

    @Test
    void 시도할_횟수에_양수가_아닌_입력시_예외_처리() {
        long input = 0;

        assertThatThrownBy(() -> Validator.validateIsPositive(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수만 입력할 수 있습니다.");
    }
}