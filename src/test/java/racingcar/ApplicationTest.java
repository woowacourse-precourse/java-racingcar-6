package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.enums.ErrorMessages;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("전진 정지")
    @Test
    void moveForwardAndStop() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
        }, MOVING_FORWARD, STOP);
    }

    @DisplayName("전진 정지 2")
    @Test
    void moveForwardAndStop2() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "2");
            assertThat(output()).contains("pobi : -", "woni : ", "pobi : -", "woni : ", "최종 우승자 : pobi, woni");
        }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD);
    }

    @DisplayName("긴 차 이름에 대한 예외 처리")
    @Test
    void longLengthCarNameTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1")).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessages.OVER_LENGTH_ERROR.getMessage())
        );
    }

    @DisplayName("공백 차 이름에 대한 예외 처리")
    @Test
    void blankInputTypeForCarNameTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi", "1")).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessages.EMPTY_ERROR.getMessage())
        );
    }

    @DisplayName("공백 이름에 대한 예외 처리 2")
    @Test
    void blankInputTypeForCarNameTest2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ,pobi", "1")).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessages.EMPTY_ERROR.getMessage())
        );
    }

    @DisplayName("숫자 형식이 아닌 회수에 대한 예외 처리")
    @Test
    void isNotNumericTypeInputTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "영")).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessages.NUMERIC_ERROR.getMessage())
        );
    }

    @DisplayName("공백 회수에 대한 예외 처리")
    @Test
    void blankInputForAttemptsTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", " ")).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessages.EMPTY_ERROR.getMessage()));
    }
    @DisplayName("0인 회수에 대한 예외 처리")
    @Test
    void zeroInputTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0")).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessages.UNDER_NUMBER_ERROR.getMessage()));
    }

    @DisplayName("음수인 회수에 대한 예외 처리")
    @Test
    void negativeNumberInputTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-1")).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessages.UNDER_NUMBER_ERROR.getMessage()));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
