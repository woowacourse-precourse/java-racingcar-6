package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void split_메서드로_주어진_값을_구분() {
        final User user = new User();
        final String input = "pobi,woni,jun";

        user.splitCarsName(input);

        assertThat(user.getCarsNameArray()).contains("pobi", "woni", "jun");
    }

    @Test
    void 예외_자동차_이름_글자수_초과() {
        final User user = new User();
        final String input = "pobi,woni,goodjun";

        assertThatThrownBy(() -> user.splitCarsName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 5자를 초과하는 자동차가 있습니다.");
    }
}