package car;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.validator.CarValidator;

public class CarCreationTest {
    @Test
    void 이름이_5자_이하인가() {
        String acceptName = "김수한무";
        String unAcceptName = "김수한무거북이";

        assertDoesNotThrow(() -> CarValidator.validateNameLength(acceptName));

        assertThrows(IllegalArgumentException.class,
            () -> CarValidator.validateNameLength(unAcceptName));
    }

    @Test
    void 입력값이_숫자_영문_쉼표로만_구성되어있는가() {
        String acceptName = "pobi,woni,jun";
        String unAcceptName = "pobi,woni;jun";

        assertDoesNotThrow(() -> CarValidator.validateNameUsingCommas(acceptName));

        assertThrows(IllegalArgumentException.class,
            () -> CarValidator.validateNameUsingCommas(unAcceptName));
    }
}
