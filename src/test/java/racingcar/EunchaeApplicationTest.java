package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EunchaeApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 최종_우승자_hamster() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("ham,ster,cute", "2");
                    assertThat(output()).contains("ham : --", "ster : ", "cute : ", "최종 우승자 : ham");
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 시도횟수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ham,ster,cute", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

