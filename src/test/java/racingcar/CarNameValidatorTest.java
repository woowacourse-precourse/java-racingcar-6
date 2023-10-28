package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.CarNameValidator;

public class CarNameValidatorTest {


    @Test
    void 이름이_5글자_이상일_경우_예외발생() {
        List<String> carNames = Arrays.asList("notebook", "Apples");
        assertThrows(IllegalArgumentException.class, () -> CarNameValidator.validateCarNames(carNames));
    }

    @Test
    void 이름이_비어있을_경우_예외발생() {
        List<String> carNames = Arrays.asList("pobi", null);
        assertThrows(IllegalArgumentException.class, () -> CarNameValidator.validateCarNames(carNames));
    }

    @Test
    void 중복된_이름이_존재할_경우_예외발생() {
        List<String> carNames = Arrays.asList("jun", "jun");
        assertThrows(IllegalArgumentException.class, () -> CarNameValidator.validateCarNames(carNames));
    }

    @Test
    void 모든_이름이_올바를_경우_예외발생하지_않음() {
        List<String> carNames = Arrays.asList("pobi", "jun", "woni");
        assertDoesNotThrow(() -> CarNameValidator.validateCarNames(carNames));
    }


}
