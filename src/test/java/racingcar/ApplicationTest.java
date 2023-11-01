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
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_입력_중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("king,king,king,King,king"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_입력_길이초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("dokgomay,uncleking"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_입력_쉼표제외_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("dokgo may cat uncle king"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_입력_숫자포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("dokgo,may,cat1,uncle2,king3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동_횟수_0_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동_횟수_문자_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
