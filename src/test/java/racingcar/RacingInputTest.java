package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcarFP.Application;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class RacingInputTest extends NsTest {
    RacingInput ri = new RacingInput();
    @Test
    public void 차_이름_5자_초과_검사()
    {
        String carNames = "car1,car2,carNameOver5Digits";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 횟수가_문자로_들어올_때_예외_검사()
    {
        String wrongTries ="가나다";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1", wrongTries))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
