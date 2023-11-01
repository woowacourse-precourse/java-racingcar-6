package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RacingCarGameTest {

    private final RacingCarGame game = new RacingCarGame();

    @Test
    void 숫자가아닌시도횟수입력() {
        assertThrows(IllegalArgumentException.class, () -> game.validateAttempts("a"));
    }

    @Test
    void 자동차이름5자초과() {
        assertThrows(IllegalArgumentException.class, () -> game.validateCarName("abcdef"));
    }

    @Test
    void stopWhenpicked3() {
        assertThat(game.goAhead(new Car("test"), 3)).isFalse();
    }

    @Test
    void goAheadWhenpicked4() {
        assertThat(game.goAhead(new Car("test"), 4)).isTrue();
    }
}