package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest extends NsTest {
    @Test
    @DisplayName("자동차 이름을 5글자 이상 입력 할 경우 예외 발생")
    void inputOverThenFiveLetters() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,yeseul", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
