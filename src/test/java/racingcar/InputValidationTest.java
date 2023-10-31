package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.exception.ErrorMessage.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class InputValidationTest extends NsTest {
    @Test
    void 중복된_이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(DUPLICATED_NAME.getMessage())
        );
    }

    @Test
    void 비어있는_이름_입력에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(EMPTY_INPUT.getMessage())
        );
    }

    @Test
    void 실행_횟수_입력_0이하_수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(LESS_THAN_ONE.getMessage())
        );
    }

    @Test
    void 실행_횟수_입력_정수가_아닌_수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1.23"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NOT_INTEGER.getMessage())
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
