package racingcar.domain.game;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private Game game = new Game();

    @Test

    void 자동차_경주_결과_출력() {
        assertRandomNumberInRangeTest(() -> {
                    run("youth", "1");
                    assertThat(output()).contains("실행 결과", "youth : -");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
        game.raceSetting();
        game.race();
    }
}
