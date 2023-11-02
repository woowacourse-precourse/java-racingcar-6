package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.model.game.GameTime;

class GameTimeTest {
    @Test
    void 이동횟수제한_1에서_100사이의_숫자만_허용_실패() {
        assertThatThrownBy(() -> new GameTime(101))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 1부터 100까지 가능합니다.");
    }

    @Test
    void 이동횟수제한_1에서_100사이의_숫자만_허용_성공() {
        assertThat(new GameTime(5)).isInstanceOf(GameTime.class);
    }
}
