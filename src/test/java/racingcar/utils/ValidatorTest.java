package racingcar.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ValidatorTest {
    Validator validator = new Validator();

    private static final String WRONG_LENGTH_CAR_NAME_ERROR_MESSAGE = "이름은 5자 이하여야 합니다";
    private static final String CAR_NAME_DUPLICATION_ERROR_MESSAGE = "이름이 중복되어선 안됩니다";
    private static final String CAR_NAME_BLANK_ERROR_MESSAGE = "이름이 비어있으면 안 됩니다";
    private static final String NOT_NUMBER_STRING_ERROE_MESSAGE = "숫자가 아닙니다";

    Parser parser = new Parser();
    
    @Test
    void 차_이름_길이_예외테스트() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validateCarNameInput("wonjun,abc,def");
        });
        assertEquals(WRONG_LENGTH_CAR_NAME_ERROR_MESSAGE, e.getMessage());
    }

    @Test
    void 차_이름_중복_예외테스트() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validateCarNameInput("abc,abc,def");
        });
        assertEquals(CAR_NAME_DUPLICATION_ERROR_MESSAGE, e.getMessage());
    }


    @Test
    void 차_이름_Blank_예외테스트() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validateCarNameInput(" ,abc,def");
        });
        assertEquals(CAR_NAME_BLANK_ERROR_MESSAGE, e.getMessage());
    }

    public String validateAttemptCountInput(String userInput) {
        try {
            parser.parseAttemptCountInput(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_STRING_ERROE_MESSAGE);
        }
        return userInput;
    }
}