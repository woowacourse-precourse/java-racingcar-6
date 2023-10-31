package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import racingcar.constants.Messages;

class RacingGameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진전진_정지정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("hee,geon", "2");
                assertThat(output()).contains("hee : --", "geon : ", "최종 우승자 : hee");
            },
            MOVING_FORWARD, STOP,
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 큰_수에_대한_동작_확인() {
        assertRandomNumberInRangeTest(
            () -> {
                run("hee,geon", "100");
                assertThat(output()).contains("hee : ", "geon : ", "최종 우승자 : hee");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차_이름_입력_검증() {
        assertRandomNumberInRangeTest(
            () -> {
                run("hee,hee", "1");
                assertThat(output()).contains("hee : -", "hee_2 : ", "최종 우승자 : hee");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차_이름_입력_검증2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("hee,geon_", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(Messages.ERROR_CAR_NAMES_UNDER_BAR.getMessage())
        );
    }

    @Test
    void 자동차_이름_입력_검증3() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(Messages.ERROR_CAR_NAMES_LENGTH.getMessage())
        );
    }

    @Test
    void 자동차_이름_입력_검증4() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi, ", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(Messages.ERROR_CAR_NAMES_BLANK.getMessage())
        );
    }


    @Test
    void 자동차_이름_입력_검증5() {
        assertRandomNumberInRangeTest(
            () -> {
                run("hee", "1");
                assertThat(output()).contains("hee : -", "최종 우승자 : hee");
            },
            MOVING_FORWARD
        );
    }

    @Test
    void 자동차_이름_입력_검증6() {
        assertRandomNumberInRangeTest(
            () -> {
                run("hee,hee,hee,hee", "1");
                assertThat(output()).contains("hee : -", "hee_2 : ", "hee_3 : ", "hee_4 : ", "최종 우승자 : hee");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 시도_횟수_입력_검증() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi", "a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(Messages.ERROR_ROUND_NUM_NUMERIC.getMessage())
        );
    }

    @Test
    void 시도_횟수_범위_검증2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi", "1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(Messages.ERROR_ROUND_NUM_RANGE.getMessage())
        );
    }

    @Test
    void 시도_횟수_범위_검증3() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(Messages.ERROR_ROUND_NUM_RANGE.getMessage())
        );
    }

    @Test
    void 시도_횟수_범위_검증4() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(Messages.ERROR_ROUND_NUM_NUMERIC.getMessage())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}