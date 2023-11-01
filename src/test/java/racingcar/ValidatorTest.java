package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ValidatorTest extends NsTest {

    @Test
    void 차_이름_중복() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("aaa,aaa", "2"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 차_개수_하나() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("aaa", "2"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 차_이름_공백() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("aaa, ", "2"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 회차_0이하() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("aaa,fff,asdf", "-1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 회차_정수_아님() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("aaa,aaa", "ee"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
