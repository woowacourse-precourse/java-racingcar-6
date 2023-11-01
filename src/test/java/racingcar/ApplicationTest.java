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
    void 자동차이름_공백_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차이름_첫문자쉼표_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",test1", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차이름_마지막문자쉼표_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("test1,", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차이름_연속쉼표_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("test1,,test2", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차이름_중복_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("test1,test1", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차이름_하나_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("test1", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차이름_5자리초과_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("test123456", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 라운드수_숫자아닌경우_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("test1,test2", "text"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
