package racingcar.exception;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputCarExceptionTest extends NsTest {

    @Test
    void 자동차_이름_5자_이하() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,siyeon", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력한_자동차의_개수가_1개_이하() {
    }

    @Test
    void 자동차_이름_공백_제거() {
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}