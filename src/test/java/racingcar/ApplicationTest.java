package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.message.ErrorMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 이름에_대한_예외_처리_쉼표가_아닌_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi  woni mike", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_CAR_NAME)
        );
    }

    @Test
    void 이름에_대한_예외_처리_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_CAR_NAME)
        );
    }

    @Test
    void 시도_횟수에_대한_예외_처리_빈_값인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", ""))
                       .isInstanceOf(IllegalArgumentException.class)
                       .hasMessage(ErrorMessage.INPUT_BLANK)
        );
    }

    @Test
    void 시도_횟수에_대한_예외_처리_숫자가_아닌_경우_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "one"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INPUT_NOT_INTEGER)
        );
    }

    @Test
    void 시도_횟수에_대한_예외_처리_숫자가_아닌_경우_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "1a2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INPUT_NOT_INTEGER)
        );
    }

    @Test
    void 시도_횟수에_대한_예외_처리_숫자가_음수인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_TRIAL_COUNT)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
