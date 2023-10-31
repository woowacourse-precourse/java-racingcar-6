package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.constant.ExceptionMessage;

class CarNameValidatorTest {

    CarNameValidator carNameValidator = new CarNameValidator();

    @Test
    void 자동차_이름이_5자를_초과할경우_예외발생() {
        assertThatThrownBy(() -> carNameValidator.validateCarName(List.of("nara", "lovenara")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_LENGTH.getMessage());
    }

    @Test
    void 자동차_이름이_중복일경우_예외발생() {
        assertThatThrownBy(() -> carNameValidator.validateCarName(List.of("nara", "nara")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_DUPLICATION.getMessage());
    }

    @Test
    void 자동차_이름이_공백일경우_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> carNameValidator.validateCarName(List.of("nara", "")));
    }

    @Test
    void 자동차_이름에_특수문자가있으면_예외발생() {
        assertThatThrownBy(() -> carNameValidator.validateCarName(List.of("nara", "n^^a")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_TYPE.getMessage());
    }

    @Test
    void 자동차_이름에_빈칸이_있을경우_예외발생() {
        assertThatThrownBy(() -> carNameValidator.validateCarName(List.of("nara", "n ra")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_TYPE.getMessage());
    }
}