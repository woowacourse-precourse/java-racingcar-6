package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 게임_진행_결과와_최종_우승자를_출력한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("foo1,foo2", "1");
                    assertThat(output()).contains("foo1 : ", "foo2 : ", "최종 우승자 : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
