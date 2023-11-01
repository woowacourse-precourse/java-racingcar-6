package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest extends NsTest {
    @Test
    void 자동차_이름_옳지_않은_입력_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(null))
                        .isInstanceOf(NullPointerException.class)
        );
    }

    @Test
    void 시도할_횟수_옳지_않은_입력_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "a"))
                        .isInstanceOf(NumberFormatException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
