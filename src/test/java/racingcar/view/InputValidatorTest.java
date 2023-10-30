package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private static InputValidator inputValidator;

    @BeforeAll
    static void setUp(){
        inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("레이싱 카 이름이 5글자 초과인 경우 테스트")
    void racingCarNameBiggerThanFiveTest(){
        String[] carNames = {"aaaaaa"};

        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateRacingCarNameLength(carNames);
        });
    }

    @Test
    @DisplayName("시도 횟수의 입력이 숫자가 아닌 경우 테스트")
    void numberOfTryIsNotNumberTest(){
        String input = "a";

        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateNumberTypeOfTry(input);
        });
    }

    @Test
    @DisplayName("시도 횟수의 입력이 1보다 작은 경우 테스트")
    void numberOfTryIsSmallerThanOne(){
        int input = -2;

        assertThrows(IllegalArgumentException.class, () ->{
           inputValidator.validateNumberRangeOfTry(input);
        });
    }
}