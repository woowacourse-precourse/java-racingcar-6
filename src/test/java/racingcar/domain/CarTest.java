package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차의_이름은_5자_이하만_가능하다() {
        assertThatThrownBy(() -> new Car("ABCDEF"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차의_이름은_공백이_될_수_없습니다() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 공백이 될 수 없습니다.");
    }

}