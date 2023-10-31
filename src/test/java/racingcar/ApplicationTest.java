package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import static racingcar.CheckException.checkPositiveNumberOfMove;
import static racingcar.CheckException.checkRightNumberOfMove;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수에_대한_예외_처리() {
        int input1 = -2;
        String input2 = "SAE";

        assertAll(
                () -> assertThatThrownBy(() -> checkPositiveNumberOfMove(input1))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("Input should be a positive number"),
                () -> assertThatThrownBy(() -> checkRightNumberOfMove(input2))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("Input should be convert to number")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
