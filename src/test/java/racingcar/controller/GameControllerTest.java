package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class GameControllerTest extends NsTest {

    private static final int MOVING = 4;
    private static final int STOP = 3;

    private final GameController controller = new GameController();

    @Test
    void 우승자가_여러명일_경우_쉼표를_이용하여_구분한다() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "2");
                assertThat(output()).contains("최종 우승자 : pobi, jun");
            },
            MOVING, STOP, MOVING, MOVING, MOVING, MOVING
        );
    }

    @Override
    protected void runMain() {
        controller.play();
    }

}