package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.exception.ErrorMessage.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.RoundCount;

public class ValidationTest extends NsTest {
    private Car car;
    private RoundCount roundCount;
    @ParameterizedTest
    @ValueSource(strings = {"", "jjjjjj"})
    void 자동차_생성_예외_테스트(String string) {
        assertThatThrownBy(() -> car = Car.create(string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(DUPLICATED_NAME.getMessage())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1.23"})
    void 실행_횟수_생성_예외_테스트(String string) {
        assertThatThrownBy(() -> roundCount = RoundCount.store(string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
