package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.exception.ErrorMessage.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarNameTest extends NsTest {
    private Car car;

    @Test
    void 비어있는_이름_예외_처리() {
        assertThatThrownBy(() -> car = Car.create(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_이름_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(DUPLICATED_NAME.getMessage())
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
