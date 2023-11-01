package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;


public class InputValidationTest extends NsTest {

    @Test
    void 이름이_없는_경우() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_공백인_경우() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 여러개의_이름이_공백인_경우() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car,,,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_주어진_길이보다_초과하는_경우() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cars,fiveCar,car", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_숫자가_아닌_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cars,car", "String"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_숫자가_음수인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cars,car", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
