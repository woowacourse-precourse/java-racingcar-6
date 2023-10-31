package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 자동차_입력받기() {
        String name = "test car";
        assertThat(name).isNotNull();
    }

    @Test
    void 구분자에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi@jun", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자에_대한_예외_처리_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi poly kevin solla", "3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 구분자에_대한_예외_처리_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobijunpoly", "2"))
                        .isInstanceOf(IllegalArgumentException.class));
    }


    @Test
    void 시도_횟수_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("povi,jun", "five"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도_횟수_예외_처리_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("povi,jun", " "))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도_횟수_예외_처리_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("povi,jun", "-1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
