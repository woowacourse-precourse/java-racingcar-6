package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest extends NsTest{
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
    void 회차_동안의_자동차의_전진_상태() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "6");
                    assertThat(output()).contains(
                            "pobi : -", "woni : ",
                            "pobi : -", "woni : -",
                            "pobi : --", "woni : -",
                            "pobi : --", "woni : --",
                            "pobi : ---", "woni : --",
                            "pobi : ---", "woni : ---"
                    );
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
    }


    @Test
    void 이름에_대한_예외_처리_4자리초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 이름에_대한_예외_처리_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 이름에_대한_예외_처리_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 입력_횟수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
