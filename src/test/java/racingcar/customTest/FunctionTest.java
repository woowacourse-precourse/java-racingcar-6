package racingcar.customTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class FunctionTest extends NsTest {
    private static final int MOVING_FORWARD = 4;

    @Test
    void 한_칸_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "6");
                    assertThat(output()).contains("pobi : ------", "woni : ", "최종 우승자 : pobi");
                },
                4, 0, 5, 1, 6, 2, 7, 3, 8, 3, 9, 3
        );
    }

    @Test
    void 단독_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD - 1
        );
    }

    @Test
    void 공동_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD + 1
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
