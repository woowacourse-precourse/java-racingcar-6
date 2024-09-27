package racingcar.verifier;


import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.system.ExceptionMessage;

import static org.assertj.core.api.Assertions.*;

class CarNameVerifierTest extends NsTest {

    @Nested
    class ValidInputTest {
        @Test
        void 정상입력이_주어진경우() {
            Assertions.assertSimpleTest(() ->
                    assertThatCode(() -> run("pobi,woni,jun", "3"))
                            .doesNotThrowAnyException()
            );
        }
    }

    @Nested
    class ExceptionTest {
        @Test
        void 자동차이름의_길이가이_5자초과인_경우() {
            Assertions.assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,woni,123456,ifj", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(ExceptionMessage.INVALID_CAR_NAME)
            );
        }

        @Test
        void 자동차이름의_길이가_1자미만인_경우() {
            Assertions.assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(",,pobi,woni", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(ExceptionMessage.INVALID_CAR_NAME)
            );
        }

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}