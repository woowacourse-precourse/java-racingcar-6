package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ValidationTest  extends NsTest {
    @Test
    void count에_숫자만_입력_가능() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,java", "string"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void count에_음수_입력_불가능() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,java", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void count에_0은_입력_불가능() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,java", "0"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 빈_이름_입력_불가() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi, ,", "2"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
