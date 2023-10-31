package racingcar.utils;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationUtilTest extends NsTest {

    @Test
    @DisplayName("중복된_이름에_대한_예외_처리")
    void testDuplicateRacingCarName() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차_입력값이_빈문자열인_경우")
    void testRacingCarIsEmpty() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("횟수_입력값이_빈문자열인_경우")
    void testAttemptIsEmpty() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("숫자가_아닌_횟수에_대한_예외_처리")
    void testAttemptNotANumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "1s"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("횟수가_1보다_작은_경우에_대한_예외_처리")
    void testAttemptLessThanOne() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}