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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 예외_carName_중복값_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,sun,sun,sunny", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_car_Name_공백이_있는_중복값_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,sun, sun   ,sunny", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_car_Name_빈값_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_시도_횟수_0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("서니,sun,지니", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_시도_횟수_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("서니,sun,지니", "-8"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_시도_횟수_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("서니,sun,지니", "야"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
