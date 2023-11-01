package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ExceptionTest extends NsTest {
    @Test
    void 자동차_이름_입력값_쉼표_없음_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobijunker", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
