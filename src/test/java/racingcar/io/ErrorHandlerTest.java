package racingcar.io;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class ErrorHandlerTest {
    ErrorHandler errorHandlerTest = new ErrorHandler();

    @Test
    void 입력값은_5이하여야_합니다() {
        assertThrows(IllegalArgumentException.class, () -> errorHandlerTest.checkLength("123456"));
    }

    @Test
    void 입력값은_고유해야_합니다() {
        HashMap<String, Integer> playingStatus = new HashMap<>() {{
            put("scott", 0);
            put("123", 0);
        }};
        assertThrows(IllegalArgumentException.class, () -> errorHandlerTest.checkUnique("123", playingStatus));
    }
}