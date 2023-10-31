package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import racingcar.domain.PlayerName;

public class PlayerNameTest {

    @Test
    void 플레이어_이름이_다섯자를_초과하면_예외를_발생한다() {
        assertThatThrownBy(() -> PlayerName.from("iamSix")).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 플레이어_이름이_다섯자를_이하면_예외를_발생시키지_않는다() {
        assertDoesNotThrow(() -> PlayerName.from("fives"));
    }
}
