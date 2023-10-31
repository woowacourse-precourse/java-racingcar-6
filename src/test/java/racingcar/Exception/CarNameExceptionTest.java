package racingcar.Exception;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CarNameExceptionTest {
    @Test
    void testValidateCarNameInput_ValidInput_올바른_입력() {
        CarNameException carNameException = new CarNameException();
        String carNameInput = "pobi,woni,jun";

        assertDoesNotThrow(() -> carNameException.validateCarNameInput(carNameInput));
    }

    @Test
    void testValidateCarNameInput_NoInput_입력값_없음() {
        CarNameException carNameException = aCarNameException();
        String carNameInput = "";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carNameException.validateCarNameInput(carNameInput));
        assertThat(exception.getMessage()).isEqualTo("값을 입력해주세요.");
    }

    @Test
    void testValidateCarNameInput_LastInputComma_입력값_끝_쉼표() {
        CarNameException carNameException = aCarNameException();
        String carNameInput = "pobi,woni,jun,";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carNameException.validateCarNameInput(carNameInput));
        assertThat(exception.getMessage()).isEqualTo("자동차 이름은 1글자 이상이어야 합니다.");
    }

    @Test
    void testValidateCarNameInput_InvalidLength_길이_미만() {
        CarNameException carNameException = aCarNameException();
        String carNameInput = ",woni,jun";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carNameException.validateCarNameInput(carNameInput));
        assertThat(exception.getMessage()).isEqualTo("자동차 이름은 1글자 이상이어야 합니다.");
    }

    @Test
    void testValidateCarNameInput_InvalidLength_길이_초과() {
        CarNameException carNameException = new CarNameException();
        String carNameInput = "pobi,woniwoni,jun";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carNameException.validateCarNameInput(carNameInput));
        assertThat(exception.getMessage()).isEqualTo("자동차 이름은 5글자 이하여야 합니다.");
    }

    @Test
    void testValidateCarNameInput_CarNameWithSpace_공백이_포함된_이름() {
        CarNameException carNameException = new CarNameException();
        String carNameInput = "po bi,woni,jun";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carNameException.validateCarNameInput(carNameInput));
        assertThat(exception.getMessage()).isEqualTo("자동차 이름안에는 공백이 있어서는 안됩니다.");
    }


    @Test
    void testValidateCarNameInput_DuplicateCarName_중복된_이름() {
        CarNameException carNameException = new CarNameException();
        String carNameInput = "pobi,pobi,woni";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carNameException.validateCarNameInput(carNameInput));
        assertThat(exception.getMessage()).isEqualTo("같은 이름을 가진 자동차가 있습니다.");
    }


    private CarNameException aCarNameException() {
        return new CarNameException();
    }
}