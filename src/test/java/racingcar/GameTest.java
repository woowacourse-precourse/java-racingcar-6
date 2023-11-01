package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class GameTest extends NsTest {
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void printWell() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : ---", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void nameNoInput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void nameLastComma() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void nameOverFive() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,donghaoh", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void nameDuplicate() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,dong,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
