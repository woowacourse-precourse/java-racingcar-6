package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class PlayerNameTest {

    @Test
    void 플레이어_이름이_다섯자를_초과하면_예외를_발생한다() {
        PlayerName playerName = new PlayerName();
        assertThatThrownBy(() -> playerName.validateLength("iamSix")).
            isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 플레이어_이름이_다섯자를_이하면_예외를_발생시키지_않는다() {
        PlayerName playerName = new PlayerName();
        assertDoesNotThrow(() -> playerName.validateLength("fives"));
    }
}
