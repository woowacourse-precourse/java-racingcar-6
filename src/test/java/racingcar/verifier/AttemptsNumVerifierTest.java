package racingcar.verifier;


import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.system.ExceptionMessage;

import static org.assertj.core.api.Assertions.*;

class AttemptsNumVerifierTest extends NsTest {

    @Nested
    class ValidInputTest {
        @Test
        void 정상입력이_주어진경우() {
            Assertions.assertSimpleTest(() -> {
                assertThatCode(() -> run("pobi,woni,jun", "23"))
                        .doesNotThrowAnyException();
            });
        }
    }

    @Nested
    class ExceptionTest {
        @Test
        void 숫자가아닌입력이_주어진경우() {
            Assertions.assertSimpleTest(() ->
                    assertThatThrownBy(() -> run("pobi,woni,jun", "35k"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(ExceptionMessage.NOT_NUMERIC)
            );
        }

        @Test
        void 유효한범위의_숫자가_아닌_입력이_아닌경우() {
            Assertions.assertSimpleTest(() -> {
                assertThatThrownBy(() -> run("pobi,woni,jun", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessage.INVALID_NUM_OF_ATTEMPTS);
            });
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}