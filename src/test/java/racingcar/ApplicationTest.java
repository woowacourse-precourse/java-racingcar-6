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
    void 전진_정지2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c,d,e,f,g,h,i,j", "1");
                    assertThat(output()).contains("a : ", "b : ", "c : ", "d : ", "e : -", "f : -",
                            "g : -", "h : -", "i : -", "j : -", "최종 우승자 : e, f, g, h, i, j");
                },
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        );
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c,d,e,f,g,h,i,j", "1");
                    assertThat(output()).contains("a : ", "b : -", "c : ", "d : -", "e : ", "f : -",
                            "g : ", "h : -", "i : -", "j : -", "최종 우승자 : b, d, f, h, i, j");
                },
                0, 9, 1, 8, 2, 7, 3, 6, 4, 5
        );
    }

    @Test
    void 우승자_출력_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : -", "woni : ", "jun : ", "pobi : -", "woni : -",
                            "jun : ", "pobi : -", "woni : -", "jun : -", "최종 우승자 : pobi, woni, jun");
                },
                MOVING_FORWARD, STOP, STOP, STOP, MOVING_FORWARD, STOP, STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,,,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 회수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-10"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
