package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(new String[]{"car1", "car2"}, "3");
    }

    @Test
    void 게임_생성_성공() {
        assertThat(game).isNotNull();
    }

    @Test
    void 게임_횟수_예외() {

        // 음수
        assertThatThrownBy(() -> new Game(new String[]{"car1", "car2"}, "-1"))
            .isInstanceOf(IllegalArgumentException.class);

        // 숫자가 아닐때
        assertThatThrownBy(() -> new Game(new String[]{"car1", "car2"}, "cnt"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
