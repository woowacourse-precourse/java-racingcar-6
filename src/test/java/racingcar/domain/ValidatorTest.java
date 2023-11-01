package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @Test
    void 길이가_5보다_큰_문자열이_존재하는_경우_예외_발생() {
        List<String> input = new ArrayList<>();
        input.add("hello");
        input.add("aaaaaa");

        assertThatThrownBy(() -> Validator.validateCarsName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 문자열을_정수로_바꿀수_없는_경우_예외_발생() {
        String input = "a";

        assertThatThrownBy(() -> Validator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자를 입력하세요.");
    }
}
