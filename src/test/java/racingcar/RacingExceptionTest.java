package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.global.message.ErrorMessage;
import org.junit.jupiter.api.Test;
import racingcar.view.InputValidator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingExceptionTest extends NsTest {

    @Test
    void 빈_Car_이름_입력에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쉼표만_있는_이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쉼표로_끝나고_공백_입력에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim, ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_시도_횟수_입력시_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hello,world"," "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
