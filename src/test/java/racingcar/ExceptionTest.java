package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExceptionTest {
    private Exception exception;

    @BeforeEach
    void beforeEach() {
        exception = new Exception();
    }

    @Test
    void 입력값_쉼표로_시작하지_않는다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.validateInputNotStartWithComma(",abcd");
        });

        Assertions.assertDoesNotThrow(() -> {
            exception.validateInputNotStartWithComma("abcd");
        });
    }

    @Test
    void 입력값_쉼표_중복_X() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.validateInputContainsConsecutiveCommas("ab,,cd");
        });

        Assertions.assertDoesNotThrow(() -> {
            exception.validateInputContainsConsecutiveCommas("ab,cd");
        });
    }

}
