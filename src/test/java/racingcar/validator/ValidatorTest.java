package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void 자동차의_이름이_5자를_넘은_경우_예외_처리() {
        String input = "abcdef";

        assertThatThrownBy(() -> Validator.validateUnderFiveLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5자 이하로 입력해야 합니다.");
    }

    @Test
    void 자동차의_이름이_공백으로_이루어진_경우_예외_처리() {
        String input = "";

        assertThatThrownBy(() -> Validator.validateIsBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름으로 공백은 사용할 수 없습니다.");
    }

    @Test
    void 자동차의_이름이_중복되는_경우_예외_처리() {
        List<String> input = List.of("pobi,pobi,jun");

        assertThatThrownBy(() -> Validator.validateIsDuplicate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 이름을 입력해야 합니다.");
    }

}