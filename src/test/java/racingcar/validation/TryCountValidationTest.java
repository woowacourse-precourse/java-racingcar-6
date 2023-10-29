package racingcar.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputManager;

public class TryCountValidationTest {
    InputManager inputManager;
    @BeforeEach
    public void beforeEach(){
        inputManager = new InputManager();
    }

    @Test
    void isValidateTryCount_성공() {
        //given
        String input = "5";
        //when
        Boolean result = inputManager.isValidateTryCount(input);
        //then
        Assertions.assertEquals(true, result);
    }

    @Test
    void isValidateTryCount_실패_숫자가_아닌_경우() {
        //given
        String input = "a";
        //when
        Boolean result = inputManager.isValidateTryCount(input);
        //then
        Assertions.assertEquals(false, result);
    }

    @Test
    void isValidateTryCount_실패_1보다_작은_경우() {
        //given
        String input = "0";
        //when
        Boolean result = inputManager.isValidateTryCount(input);
        //then
        Assertions.assertEquals(false, result);
    }
}
