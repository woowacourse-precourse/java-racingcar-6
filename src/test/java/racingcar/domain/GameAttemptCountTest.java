package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameAttemptCountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -10, 0})
    public void 시도_회수는_0보다_커야한다(int attemptCount) {
        // when, then
        Assertions.assertThatThrownBy(() -> new GameAttemptCount(attemptCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 1000, 10000})
    public void 시도_회수는_100보다_작아야한다(int attemptCount) {
        // when, then
        Assertions.assertThatThrownBy(() -> new GameAttemptCount(attemptCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 99})
    public void 시도_회수는_1보다_크고_100보다_작으면_GameAttemptCount_객체를_생성할_수_있다(int attemptCount) {
        // given, when
        GameAttemptCount gameAttemptCount = new GameAttemptCount(attemptCount);

        // then
        Assertions.assertThat(gameAttemptCount).isNotNull();
    }

    @Test
    public void 시도_회수를_1씩_감소시킬_수_있다() {
        // given
        GameAttemptCount gameAttemptCount = new GameAttemptCount(1);

        // when
        gameAttemptCount.reduceAttemptCount();
        boolean actual = gameAttemptCount.isEnd();

        // then
        Assertions.assertThat(actual).isTrue();
    }

}