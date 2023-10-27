package car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.CarValidator;

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

}
