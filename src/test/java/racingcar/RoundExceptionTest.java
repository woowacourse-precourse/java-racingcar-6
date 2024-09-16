package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundExceptionTest extends NsTest {
    @Test
    void 진행_횟수_입력시_자연수_외_숫자_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c,d", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 진행_횟수_입력시_자연수_외_숫자_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c,d,h,j,z", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 진행_횟수_입력시_자연수_외_숫자_예외_처리3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c,d", "-14314313443"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 진행_횟수_입력시_숫자_외_문자_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c,d,ef,g", "-"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 진행_횟수_입력시_숫자_외_문자_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c,d", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 진행_횟수_입력시_숫자_외_문자_예외_처리3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,bc", ""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 진행_횟수_입력시_숫자_외_문자_예외_처리4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b", "  4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 진행_횟수_입력시_숫자_외_문자_예외_처리5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c", "3 "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 진행_횟수_입력시_숫자_외_문자_예외_처리6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c,d", "한번"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 진행_횟수_입력시_20초과_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c", "21"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 진행_횟수_입력시_20초과_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c", "3000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
