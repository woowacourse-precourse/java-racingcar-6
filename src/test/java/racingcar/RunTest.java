package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RunTest extends NsTest {
    @org.junit.jupiter.api.Test
    void 이름이_5자가_넘어가면_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("human,animal", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @org.junit.jupiter.api.Test
    void 이름이_공백이면_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("human,,alien", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @org.junit.jupiter.api.Test
    void 반복횟수입력값이_0이면_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("human,alien", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @org.junit.jupiter.api.Test
    void 반복횟수입력값이_음수이면_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("human,alien", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @org.junit.jupiter.api.Test
    void 반복횟수입력값이_문자열이면_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("human,alien", "friend"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
