package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class racingcarTest extends NsTest {
    @Test
    void 숫자입력예외처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("soft,hard", "e"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수예외처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("soft,hard", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
