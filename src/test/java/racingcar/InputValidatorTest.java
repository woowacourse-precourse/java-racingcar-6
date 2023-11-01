package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.utils.Message;

public class InputValidatorTest extends NsTest {

    @Test
    void 사용자_입력_공백_예외발생_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("woo,,woo", "10"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.ERROR_EMPTY_CAR_NAME_MESSAGE.getMessage())
        );
    }

    @Test
    void 자동차_이름_중복_입력_예외발생_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("woo,teco,woo", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.ERROR_DUPLICATE_CAR_NAME_MESSAGE.getMessage())
        );
    }

    @Test
    void 자동차_이름_입력_길이_예외발생_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,wooteco", "4"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.ERROR_INVALID_CAR_NAME_LENGTH_MESSAGE.getMessage())
        );
    }

    @Test
    void 이동_횟수_입력_문자_포함_예외발생_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c,d,e", "ha"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.ERROR_NON_NUMBERIC_MOVE_COUNT_MESSAGE.getMessage())
        );
    }

    @Test
    void 이동_횟수_입력_음수_예외발생_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b", "-4"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.ERROR_NON_NEGATIVE_MOVE_COUNT_MESSAGE.getMessage())
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
