package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.car.NameRule.LENGTH_IS_OVER_MAX;
import static racingcar.domain.car.NameRule.NOT_ALPHABETIC;

import org.junit.jupiter.api.Test;

public class NameTest {
    @Test
    void 이름이_5글자_초과일_경우_예외_발생() {
        assertThatThrownBy(() -> new Name("abcdef")).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_IS_OVER_MAX);
    }

    @Test
    void 영어_대소문자가_아닐_경우_예외_발생() {
        assertThatThrownBy(() -> new Name("abc1e")).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALPHABETIC);
    }
}
