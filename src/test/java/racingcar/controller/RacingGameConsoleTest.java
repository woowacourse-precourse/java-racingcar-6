package racingcar.controller;

import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.util.Constants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameConsoleTest {
    private MoveStrategy moveStrategy;

    @BeforeEach
    void setUp() {
        moveStrategy = new RandomMoveStrategy();
    }

    @Test
    void 레이싱_게임_생성_테스트() {
        RacingGameConsole racingGameConsole = new RacingGameConsole(moveStrategy);

        assertThat(racingGameConsole).isNotNull();
    }

    @Test
    void 이동_전략이_null인_경우_예외_발생() {
        assertThatThrownBy(() -> new RacingGameConsole(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.INVALID_MOVE_STRATEGY_NULL);
    }
}