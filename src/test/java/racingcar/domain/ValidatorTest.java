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
                .hasMessageContaining("[ERROR] 이름은 5자 이하만 가능합니다.");
    }
}
