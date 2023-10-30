package racingcar.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputExceptionTest {
    private UserInputException userInputException;

    @BeforeEach
    void setUp(){
        userInputException = new UserInputException();
    }
    private static final String LENGTH_ERROR_MESSAGE = "자동차 이름은 1 이상, 5 이하로 입력해 주세요";
    private static final String BLANK_STRING_MESSAGE = "빈 문자를 입력하셨습니다.";
    private static final String DUPLICATE_MESSAGE = "자동차 이름은 중복되지 않게 입력해주세요";
    private static final String ONLY_COMMA = "구분자는 쉼표로만 작성해주세요";
    private static final String INPUT_MORE_THAN_TWO_CAR = "차를 두대 이상 입력해주세요";

    @Test
    void 이름_길이가_유효할_때() {
        String input = "abc";
        assertDoesNotThrow(() -> UserInputException.isLength(input));
    }
    @Test
    void 이름_길이가_유효하지_않을_때() {
        String input = "adddaddad";
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

    @Test
    void 중복된_값이_존재_할_때(){
        String input = "jun,pobi,woni";
        List<String> carName = Arrays.asList(input.split(","));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> UserInputException.isDuplicate(carName));
        assertEquals(DUPLICATE_MESSAGE, exception.getMessage());
    }

    @Test
    void 중복된_값이_존재하지_않을_때() {
        String input = "jun,jun,woni";
        List<String> carName = Arrays.asList(input.split(","));
        assertDoesNotThrow(() -> UserInputException.isDuplicate(carName));
    }

    @Test
    void 컴마_숫자_문자_이외의_것_일_때() {
        String input = "pobi@woni,jun";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> UserInputException.isComma(input));
        assertEquals(ONLY_COMMA, exception.getMessage());
    }
    @Test
    void 컴마_숫자_문자만_있을_때(){
        String input = "pobi,woni,jun";
        assertDoesNotThrow(() -> UserInputException.isComma(input));
    }


}