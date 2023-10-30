package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.UserInputException;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
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
    void 사용자_입력_중_차_중복_입력(){
        //ㄱㅊ
        String input = "pobi,pobi,woni";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> UserInputException.isDuplicate(input));
        assertEquals(DUPLICATE_MESSAGE, exception.getMessage());
    }

    @Test
    void 사용자_입력_중_입력_길이() {
        // 이거 입력 맞아도 예외 처리 뜸
        String input = "jundongee";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> UserInputException.isLength(input));
        assertEquals(LENGTH_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    void 사용자_입력_중_빈_문자() {
        String input = "po bi,woni,jun";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> UserInputException.isBlank(input));
        assertEquals(BLANK_STRING_MESSAGE, exception.getMessage());

    }

    @Test
    void 사용자_입력_중_구분자_쉼표_외에_다른_것(){
        String input = "pobi!,woni,jun";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> UserInputException.isComma(input));
        assertEquals(ONLY_COMMA, exception.getMessage());
    }

    @Test
    void 사용자_입력_차를_두_대_이상_입력하지_않았을_때(){
        String input = "pobi";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> UserInputException.isMoreThan(input));
        assertEquals(INPUT_MORE_THAN_TWO_CAR, exception.getMessage());
    }
}