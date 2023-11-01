package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class InputTest extends NsTest {
    @Test
    void 숫자입력_정수아닌값에_대한_예외_처리_(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "S"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 잘못된_차들_입력에_대한_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji,", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자입력에_음수_대한_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
