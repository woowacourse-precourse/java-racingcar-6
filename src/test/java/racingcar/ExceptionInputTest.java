package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionInputTest extends NsTest {
    private static final String SUCCESS_INPUT_NAMES = "pobi,woni";
    private static final String SUCCESS_INPUT_NUM = "1";


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 이름에_대한_예외_처리_5자이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", SUCCESS_INPUT_NUM))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리_끝문자_쉼표() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", SUCCESS_INPUT_NUM))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리_쉼표_연속() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", SUCCESS_INPUT_NUM))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 레이싱_횟수에_대한_예외_처리_제로() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(SUCCESS_INPUT_NAMES, "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 레이싱_횟수에_대한_예외_처리_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(SUCCESS_INPUT_NAMES, "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
