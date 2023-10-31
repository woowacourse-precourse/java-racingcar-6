package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차의_이름이_다섯_글자_초과인_경우_예외를_발생한다() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> new Car("pobiwoni"));
        assertThat(e.getMessage())
                .isEqualTo("자동차의 이름은 5자 이하만 가능합니다");
    }
}