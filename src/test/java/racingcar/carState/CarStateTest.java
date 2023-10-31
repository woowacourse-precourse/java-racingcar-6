package racingcar.carState;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.util.GameUtil;
import racingcar.validator.CarNameValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarStateTest {
    @Test
    void 차_이름_입력_테스트() {
        CarNameValidator validator = new CarNameValidator("1,2");
        assertThat(validator.NAMES).contains("2", "1");
        assertThat(validator.NAMES).containsExactly("1", "2");
    }
}