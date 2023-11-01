package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CarTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private Game game = new Game();

    @Test
    void 랜덤_숫자가_4이상이면_전진_기능() {
        assertRandomNumberInRangeTest(() -> {
                    run("youth,son", "1");
                    assertThat(output()).contains("youth : -");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 랜덤_숫자가_4미만이면_정지_기능() {
        assertRandomNumberInRangeTest(() -> {
                    run("youth,son", "1");
                    assertThat(output()).contains("youth : ");
                },
                STOP, STOP
        );
    }

    @Override
    protected void runMain() {
        game.raceSetting();
        game.race();
    }
}
