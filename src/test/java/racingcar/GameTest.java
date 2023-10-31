package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class GameTest extends NsTest {
    @Test
    void 이름_공백_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_5자_제한_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abcdef", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_중복_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("moi,rei,moi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_미입력_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수_0_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("moi,rei", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수_한영_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("moi,rei", "ab가"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}