package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.view.Message.ExceptionMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputUserTest extends NsTest {
    @Test
    void 자동차_개수_1개() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessage.LESS_TWO_CAR_COUNT_ERROR_MESSAGE.getMessage())
        );
    }

    @Test
    void 자동차_이름_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,,123", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessage.BLANK_OR_NULL_CAR_NAME_ERROR_MESSAGE.getMessage())
        );
    }

    @Test
    void 자동차_이름_빈칸() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,   ,123", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessage.BLANK_OR_NULL_CAR_NAME_ERROR_MESSAGE.getMessage())
        );
    }

    @Test
    void 자동차_이름_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,123,abc", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessage.DUPLICATE_CAT_NAME_ERROR_MESSAGE.getMessage())
        );
    }

    @Test
    void 자동차_이름_길이_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,123456", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessage.CAR_NAME_OVER_LENGTH_ERROR_MESSAGE.getMessage())
        );
    }


    @Test
    void 자동차_이름_길이_초과_AND_자동차_개수_1개_경우_자동차_개수_오류_우선_출력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc123", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessage.LESS_TWO_CAR_COUNT_ERROR_MESSAGE.getMessage())
        );
    }

    @Test
    void 라운드_횟수_숫자_아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3,4,5,6", "string"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessage.INPUT_STRING_ROUND_ERROR_MESSAGE.getMessage())
        );
    }

    @Test
    void 라운드_횟수_숫자_범위_0이하() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3,4,5,6", "-4"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessage.INPUT_INTEGER_ROUND_ERROR_MESSAGE.getMessage())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}