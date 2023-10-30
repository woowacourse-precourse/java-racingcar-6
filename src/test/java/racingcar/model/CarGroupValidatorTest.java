package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarGroupValidatorTest {

    @Test
    void 중복되는_자동차_이름이_있을경우_예외처리를_한다() {
        assertThatThrownBy(() -> CarGroupValidator.validate(List.of("자동차", "자동차")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름의_개수가_0이면_예외처리를_한다() {
        assertThatThrownBy(() -> CarGroupValidator.validate(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
