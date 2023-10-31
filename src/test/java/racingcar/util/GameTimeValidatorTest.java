package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameTimeValidatorTest {
    @Test
    void 이동횟수제한_1에서_100사이의_숫자만_허용_실패() {
        int failGameTime = 101;
        assertThatThrownBy(() -> GameTimeValidator.validateGameTime(failGameTime))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 1부터 100까지 가능합니다.");
    }

    @Test
    void 이동횟수제한_1에서_100사이의_숫자만_허용_성공() {
        int successGameTime = 5;
        assertThat(GameTimeValidator.validateGameTime(successGameTime)).isEqualTo(successGameTime);
    }
}
