package car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.validator.CarValidator;

public class CarCreationTest {

    private final CarValidator carValidator = new CarValidator();

    @Test
    void 이름이_5자_이하인가() {
        String acceptName = "김수한무";
        String unAcceptName = "김수한무거북이";

        assertDoesNotThrow(() -> carValidator.validateNameLength(acceptName));

        assertThrows(IllegalArgumentException.class,
            () -> carValidator.validateNameLength(unAcceptName));
    }

    @Test
    void 입력값이_숫자_영문_쉼표로만_구성되어있는가() {
        String acceptName = "pobi,woni,jun";
        String unAcceptName = "pobi,woni;jun";

        assertDoesNotThrow(() -> carValidator.validateNameUsingCommas(acceptName));

        assertThrows(IllegalArgumentException.class,
            () -> carValidator.validateNameUsingCommas(unAcceptName));
    }
}
