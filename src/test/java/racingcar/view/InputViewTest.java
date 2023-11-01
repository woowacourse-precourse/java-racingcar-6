package racingcar.view;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.Application;

class InputViewTest extends NsTest {
    @Test
    void 이름은_5자_이하여야_한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,abcedf", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름은_공백일_수_없다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,   ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름은_중복될_수_없다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수는_공백일_수_없다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수는_숫자로만_구성되어야_한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun", "12b."))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수는_0보다_큰_자연수여야_한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun", "-12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}