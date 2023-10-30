package racingcar.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputExceptionTest {
    private UserInputException userInputException;
    private static final String LENGTH_ERROR_MESSAGE = "자동차 이름은 1 이상, 5 이하로 입력해 주세요";

    @Test
    void 이름_길이가_유효할_때() {
        String input = "abc";
        assertDoesNotThrow(() -> UserInputException.isLength(input));
    }
    @Test
    void 이름_길이가_유효하지_않을때() {
        String input = "";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> UserInputException.isLength(input));
        assertEquals(LENGTH_ERROR_MESSAGE, exception.getMessage());
    }

}