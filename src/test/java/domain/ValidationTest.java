package domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.constant.ExceptionMessage;
import racingcar.domain.Attempt;
import racingcar.domain.CarsFactory;

public class ValidationTest extends NsTest {
    private CarsFactory carsFactory;
    private Attempt attempt;

    @BeforeEach
    public void setUp() {
        carsFactory = new CarsFactory();
        attempt = new Attempt();
    }

    @Test
    void 자동차_이름_검증하기() {
        List<String> carNames1 = Arrays.asList("pobi", "woni", "jun");

        assertThatCode(() -> carsFactory.validateCarNames(carNames1)).doesNotThrowAnyException();
    }

    @Test
    void 이름_예외_처리_빈_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_처리_공백문자1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_처리_공백문자2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,j un"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_처리_6자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jjuunn"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_처리_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_검증() {
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
    void 시도횟수_예외_처리_0이하의_수() {
        String attemptNumber = "-5";

        assertThatThrownBy(() ->
                attempt.validateAttemptNumber(attemptNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NON_POSITIVE_NUMBER_EXCEPTION);
    }

    @Test
    void 숫자_예외_처리_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
