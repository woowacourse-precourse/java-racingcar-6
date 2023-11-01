package racingcar.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class CarValidatorTest extends NsTest {
    @Test
    @DisplayName("validateInputSize 함수 기능 테스트")
    void 자동차_이름이_5자_이상일_때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("boradori,duubinana,bboo", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
