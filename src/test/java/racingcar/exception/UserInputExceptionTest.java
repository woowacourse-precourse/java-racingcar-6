package racingcar.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputExceptionTest {
    private UserInputException userInputException;
    private static final String LENGTH_ERROR_MESSAGE = "자동차 이름은 1 이상, 5 이하로 입력해 주세요";
    private static final String BLANK_STRING_MESSAGE = "빈 문자를 입력하셨습니다.";

    @Test
    void 이름_길이가_유효할_때() {
        String input = "abc";
        assertDoesNotThrow(() -> UserInputException.isLength(input));
    }
    @Test
    void 이름_길이가_유효하지_않을_때() {
        String input = "asdfadsfasdf";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> UserInputException.isLength(input));
        assertEquals(LENGTH_ERROR_MESSAGE, exception.getMessage());
    }
    @Test
    void 빈칸이_포함_됐을_때(){
        String input = "po bi,jundo";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> UserInputException.isBlank(input));
        assertEquals(BLANK_STRING_MESSAGE, exception.getMessage());
    }
    @Test
    void 빈칸이_포함_안_됐을_때() {
        String input = "pobi,jundo";
        assertDoesNotThrow(() -> UserInputException.isBlank(input));
    }


}