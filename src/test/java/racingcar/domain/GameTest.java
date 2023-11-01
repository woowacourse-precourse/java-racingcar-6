package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameTest {
    private static final int MIN_ROUND_COUNT = 1;
    private static final int MAX_ROUND_COUNT = 10;
    private Game game;

    @Test
    void 라운드_범위_초과_예외_처리() {
        assertThatThrownBy(() -> {
            Game.createNewGame(MAX_ROUND_COUNT + 1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 10 이하의 자연수여야 함");
    }

    @Test
    void 실행된_라운드_1회_증가() {
        game = Game.createNewGame(1);
        game.incrementExecutedRoundCount();
        assertThat(game).extracting("executedRoundCount").isEqualTo(1);
    }

    @Test
    void 두_라운드값_같을시_게임_종료_true() {
        game = Game.createNewGame(1);
        game.incrementExecutedRoundCount();
        assertThat(game.isGameEnd()).isTrue();
    }
}