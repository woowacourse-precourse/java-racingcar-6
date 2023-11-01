package racingcar.io;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ErrorHandlerTest {
    ErrorHandler errorHandlerTest = new ErrorHandler();

    @Test
    void 입력값은_5이하여야_합니다() {
        assertThrows(IllegalArgumentException.class, () -> errorHandlerTest.checkLength("123456"));
    }
}