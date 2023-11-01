package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jjweidon", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jjw", "3");
                    assertThat(output()).contains("pobi : -", "woni : ", "jjw : -", "pobi : -", "woni : -", "jjw : --", "pobi : --", "woni : -", "jjw : --","최종 우승자 : pobi, jjw");
                },
                5, 1, 9, 3, 7, 6, 5, 2, 0
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
