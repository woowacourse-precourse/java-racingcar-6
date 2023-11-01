package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest extends NsTest {
    @Test
    void 이름의_구분이_쉼표가_아닐_때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi;woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 공백을_입력할_때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 시도횟수가_숫자가_아닐_때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "two"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
