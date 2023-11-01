package racingcar.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserCarNameInputExceptionTest  {
    private UserCarNameInputException userCarNameInputException;

    @BeforeEach
    void setUp(){
        userCarNameInputException = new UserCarNameInputException();
    }
    private static final String LENGTH_ERROR_MESSAGE = "자동차 이름은 1 이상, 5 이하로 입력해 주세요";
    private static final String BLANK_STRING_MESSAGE = "빈 문자를 입력하셨습니다.";
    private static final String DUPLICATE_MESSAGE = "자동차 이름은 중복되지 않게 입력해주세요";
    private static final String ONLY_COMMA = "구분자는 쉼표로만 작성해주세요";
    private static final String INPUT_MORE_THAN_TWO = "차는 두 대 이상으로 입력하세요";

    @Test
    void 이름_길이가_유효할_때() {
        String input = "abc";
        assertDoesNotThrow(() -> UserCarNameInputException.isLength(input));
    }
    @Test
    void 이름_길이가_유효하지_않을_때() {
        String input = "adddaddad";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> UserCarNameInputException.isLength(input));
        assertEquals(LENGTH_ERROR_MESSAGE, exception.getMessage());
    }
    @Test
    void 빈칸이_포함_됐을_때(){
        String input = "po bi,jundo";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> UserCarNameInputException.isBlank(input));
        assertEquals(BLANK_STRING_MESSAGE, exception.getMessage());
    }
    @Test
    void 빈칸이_포함_안_됐을_때() {
        String input = "pobi,jundo";
        assertDoesNotThrow(() -> UserCarNameInputException.isBlank(input));
    }

    @Test
    void 중복된_값이_존재_할_때(){
        String input = "jun,jun,woni";
        List<String> carName = Arrays.asList(input.split(","));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> UserCarNameInputException.isDuplicate(carName));
        assertEquals(DUPLICATE_MESSAGE, exception.getMessage());
    }

    @Test
    void 중복된_값이_존재하지_않을_때() {
        String input = "jun,pobi,woni";
        List<String> carName = Arrays.asList(input.split(","));
        assertDoesNotThrow(() -> UserCarNameInputException.isDuplicate(carName));
    }

    @Test
    void 컴마_숫자_문자_이외의_것_일_때() {
        String input = "pobi@woni,jun";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> UserCarNameInputException.isComma(input));
        assertEquals(ONLY_COMMA, exception.getMessage());
    }
    @Test
    void 컴마_숫자_문자만_있을_때(){
        String input = "pobi,woni,jun";
        assertDoesNotThrow(() -> UserCarNameInputException.isComma(input));
    }

    @Test
    void 차_두_대_이상_입력_하지_않았을_때(){
        String input = "pobi";
        List<String> carName = Arrays.asList(input.split(","));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> UserCarNameInputException.isMoreThan(carName));
        assertEquals(INPUT_MORE_THAN_TWO, exception.getMessage());
    }

}