package racingcar.domain.game;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

public class WinnerTest extends NsTest {
    private static final int STOP = 3;
    private static final int MOVING_FORWARD = 4;

    private Game game = new Game();

    @Test
    void 우승자_선정() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,youth", "1");
                    Assertions.assertThat(output()).contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    protected void runMain() {
        game.raceSetting();
        game.race();
        game.declareWinner();
    }
}
