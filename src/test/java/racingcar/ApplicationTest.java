package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    void 숫자가_아닌_문자에_대한_예외_처리() {
        String input = "가";
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.validateMoveCount(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수에_대한_예외_처리() {
        String input = "-1";
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.validateMoveCount(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void _0에_대한_예외_처리() {
        String input = "0";
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.validateMoveCount(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
