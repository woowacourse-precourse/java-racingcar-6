package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import racingcar.model.Player;

public class PlayerTest {

    @Test
    void 자동차_이름에_오류가_존재하면_예외_처리() {
        Player player = new Player();
        assertThatThrownBy(() -> player.setCarName("pobiii,jun"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름에_오류가_존재하지_않는다면_저장() {
        Player player = new Player();
        assertDoesNotThrow(() -> player.setCarName("pobi,jun"));
    }

    @Test
    void 시도회수에_오류가_존재하면_예외_처리() {
        Player player = new Player();
        assertThatThrownBy(() -> player.setAttemptNumber("가나다"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도회수에_오류가_존재하지_않는다면_저장() {
        Player player = new Player();
        assertDoesNotThrow(() -> player.setAttemptNumber("3"));
    }
}