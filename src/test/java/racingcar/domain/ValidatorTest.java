package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @Test
    void 이름을_입력하지_않은_경우_예외_발생() {
        List<String> input = new ArrayList<>();

        assertThatThrownBy(() -> Validator.validateCarsName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이름을 제대로 입력해주세요.");
    }

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
    void 같은_이름이_2개_이상_존재하는_경우_예외_발생() {
        List<String> input = new ArrayList<>();
        input.add("A");
        input.add("B");
        input.add("A");
        input.add("C");

        assertThatThrownBy(() -> Validator.validateCarsName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 같은 이름이 존재합니다.");
    }

    @Test
    void 문자열을_정수로_바꿀수_없는_경우_예외_발생() {
        String input = "a";

        assertThatThrownBy(() -> Validator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자를 입력하세요.");
    }

    @Test
    void 시도_횟수가_음수인_경우() {
        String input = "-1";

        assertThatThrownBy(() -> Validator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수가 0보다 작습니다.");
    }
}
