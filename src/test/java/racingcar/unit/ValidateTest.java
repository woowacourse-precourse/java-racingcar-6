package racingcar.unit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.validation.CarNameValidator;
import racingcar.validation.Triesvalidator;

public class ValidateTest {
    @Test
    public void testNameLengthLessThanSix() {
        assertDoesNotThrow(() -> {
            CarNameValidator.validate("jiown");
        });
    }

    @Test
    public void testNameLengthSixOrMoreThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validate("JamesBond");
        });
    }

    @Test
    public void testNameLengthExactlySixThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validate("123456");
        });
    }

    @Test
    public void testTriesCount() {
        assertThrows(IllegalArgumentException.class, () -> {
            Triesvalidator.validate("-1");
        });
    }

    @Test
    public void testTriesNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            Triesvalidator.validate("jiwon");
        });
    }
}
