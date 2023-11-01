package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 9;
    private static final int STOP = 0;

    @Test
    void 정상_테스트_레이스_1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : -", "woni : ", "pobi : --", "woni : ", "pobi : ---", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 정상_테스트_레이스_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "4");
                    assertThat(output()).contains("pobi : -", "woni : ", "pobi : --", "woni : ", "pobi : --", "woni : -", "pobi : --", "woni : --", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 정상_테스트_레이스_3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : ", "woni : ", "pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                },
                STOP, STOP, STOP, STOP
        );
    }

    @Test
    void 예외_테스트_긴_이름() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_짧은_이름() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_너무_많은_시도_횟수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,juhan", "2000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_너무_적은_시도_횟수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,juhan", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
