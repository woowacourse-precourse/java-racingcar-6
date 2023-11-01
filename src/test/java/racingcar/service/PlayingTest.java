package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Playing;

public class PlayingTest {
    private final String racingCarNames = "pobi,woni,jun";
    private final int tryCount = 5;

    @Test
    void Playing_객체_생성하기() {
        Playing playing = new Playing(racingCarNames, tryCount);
        Assertions.assertThat(playing.racingCars().size()).isEqualTo(3);
        Assertions.assertThat(playing.tryCount()).isEqualTo(5);
    }

    @Test
    void tryCount_유효하지_않은_숫자값_받기() {
        int invalidValue = 0;
        Assertions.assertThatThrownBy(() -> new Playing(racingCarNames, invalidValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 회수는 1 이상이어야 합니다.");
    }
}
