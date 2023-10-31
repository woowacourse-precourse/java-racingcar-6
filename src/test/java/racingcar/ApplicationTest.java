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
    void 이름이_한글일_때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("한글,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_숫자일_때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름의_길이가_5자리_초과일때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abcdef,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_공백일_때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_다른_특수문자가_포함될_때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi@,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 실행_횟수가_0_이하일_때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 실행_횟수가_10000_초과할_때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun", "10001"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 실행_횟수가_영문_일때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun", "pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 실행_횟수가_공백일_때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
