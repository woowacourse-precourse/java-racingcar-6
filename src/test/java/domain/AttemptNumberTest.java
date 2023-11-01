package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.constant.ExceptionMessage;
import racingcar.domain.Attempt;

public class AttemptNumberTest extends NsTest {
    private Attempt attempt;

    @BeforeEach
    public void setUp() {
        attempt = new Attempt();
    }

    @Test
    void 시도횟수_검증() {
        Attempt attempt = new Attempt();
        String attemptNumber = "5";

        assertThatCode(() -> attempt.validateAttemptNumber(attemptNumber)).doesNotThrowAnyException();
    }

    @Test
    void 시도횟수_예외_처리_숫자가_아닌_문자() {
        String attemptNumber = "a";

        assertThatThrownBy(() ->
                attempt.validateAttemptNumber(attemptNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NON_INTEGER_EXCEPTION);
    }

    @Test
    void 시도횟수_예외_처리_소수() {
        String attemptNumber = "5.2";

        assertThatThrownBy(() ->
                attempt.validateAttemptNumber(attemptNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NON_INTEGER_EXCEPTION);
    }

    @Test
    void 시도횟수_예외_처리_음수() {
        String attemptNumber = "-5";

        assertThatThrownBy(() ->
                attempt.validateAttemptNumber(attemptNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NON_INTEGER_EXCEPTION);
    }

    @Test
    void 시도횟수_예외_처리_공백() {
        String attemptNumber = "1 2";

        assertThatThrownBy(() ->
                attempt.validateAttemptNumber(attemptNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NON_INTEGER_EXCEPTION);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
