package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RunningTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 이름이_5자를_초과할_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("toolongname", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[Error]: Name length should be 5 or less.")
        );
    }

    @Test
    void 이름에_하이픈이_포함된_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi-", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[Error]: Invalid characters in name.")
        );
    }

    @Test
    void 중복된_이름이_포함된_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[Error]: Duplicate names are not allowed.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
