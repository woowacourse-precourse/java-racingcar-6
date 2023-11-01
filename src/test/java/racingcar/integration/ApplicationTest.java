package racingcar.integration;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 우승자가_한명_나오면_올바른_이동_결과와_우승자_출력시_통과() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,king", "7");
                    assertThat(output()).contains(
                            "pobi : -\nwoni : \nking : ",
                            "pobi : --\nwoni : -\nking : -",
                            "pobi : ---\nwoni : --\nking : --",
                            "pobi : ----\nwoni : ---\nking : ---",
                            "pobi : -----\nwoni : ----\nking : ----",
                            "pobi : ------\nwoni : ----\nking : -----",
                            "pobi : -------\nwoni : -----\nking : ------",
                            "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 우승자가_여러명_나오면_올바른_이동_결과와_모든_우승자_출력_성공시_통과() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,king", "7");
                    assertThat(output()).contains(
                            "pobi : -\nwoni : \nking : -",
                            "pobi : --\nwoni : -\nking : --",
                            "pobi : ---\nwoni : --\nking : ---",
                            "pobi : ----\nwoni : ---\nking : ----",
                            "pobi : -----\nwoni : ----\nking : -----",
                            "pobi : ------\nwoni : ----\nking : ------",
                            "pobi : -------\nwoni : -----\nking : -------",
                            "최종 우승자 : pobi, king");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
