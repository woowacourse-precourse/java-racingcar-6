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
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jav가aji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 회수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 회수를_입력하지_않을_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", ""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 차이름을_빈_값으로_입력할_경우_익명_차량_1대로_실행() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("", "3");
                    assertThat(output()).contains("이름없음 : -", "이름없음 : -", "이름없음 : --","최종 우승자 : 이름없음");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 회수_입력값이_0으로_시작하는_숫자일_경우_변환하여_사용() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "01");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자가_여러_명일_경우_쉼표를_이용하여_구분() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,hyerm", "03");
                    assertThat(output()).contains(
                            "pobi : -", "woni : ", "hyerm : -",
                            "pobi : --", "woni : -", "hyerm : -",
                            "pobi : --", "woni : --", "hyerm : --",
                            "최종 우승자 : pobi, woni, hyerm");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 이름이_없는_차가_입력될_경우_기본값으로_이름_처리() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,,woni,", "1");
                    assertThat(output()).contains("pobi : -", "이름없음 : -", "woni : ", "이름없음 : ", "최종 우승자 : pobi, 이름없음");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
