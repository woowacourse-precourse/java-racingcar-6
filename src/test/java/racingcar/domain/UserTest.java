package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;
import static racingcar.domain.User.ATTEMPTS_INT_ERROR_MESSAGE;
import static racingcar.domain.User.ATTEMPTS_NEGATIVE_ERROR_MESSAGE;
import static racingcar.domain.User.CAR_NAME_ERROR_MESSAGE;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
                .hasMessageContaining(CAR_NAME_ERROR_MESSAGE);
    }


    @ParameterizedTest
    @ValueSource(strings = {"1a", "abc", "김상혁"})
    void 예외_시행_회수_정수가_아닌_경우(String input) {
        final User user = new User();

        assertThatThrownBy(() -> user.checkAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ATTEMPTS_INT_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3"})
    void 예외_시행_회수_음수인_경우(String input) {
        final User user = new User();

        assertThatThrownBy(() -> user.checkAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ATTEMPTS_NEGATIVE_ERROR_MESSAGE);
    }
}