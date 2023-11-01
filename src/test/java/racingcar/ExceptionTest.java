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

    @Test
    void 자동차_이름_글자수_초과_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,junker", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_쉼표_종료_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,ker,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_공백_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,   ,ker", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
