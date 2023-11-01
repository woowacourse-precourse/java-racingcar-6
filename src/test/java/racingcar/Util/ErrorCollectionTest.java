package racingcar.Util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class ErrorCollectionTest extends NsTest {

    @Test
    void 빈_입력_시_에러_발생() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("\n"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.EMPTY.label());
        });
    }

    @Test
    void 숫자가_아닌_입력_시_에러_발생() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("test", "3번"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.ATTEMPT.label());
        });
    }

    @Test
    void 자동차_이름_길이_에러_발생() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("123456"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NAME.label());
        });
    }

    @Test
    void 중복된_이름_에러_발생() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("test, test"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.DUPLICATION.label());
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}