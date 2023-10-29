package racingcar.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputManager;

public class CarNameValidationTest {
    InputManager inputManager;

    @BeforeEach
    public void beforeEach(){
        inputManager = new InputManager();
    }

    @Test
    void validateCarNames_성공() {
        //given
        String input = "pobi";
        //when
        Boolean result = inputManager.isValidateCarName(input);
        //then
        assertEquals(true,result);
    }

    @Test
    void isValidateCarName_실패_이름이_없는_경우() {
        //given
        String input = "";
        //when
        Boolean result = inputManager.isValidateCarName(input);
        //then
        assertEquals(false,result);
    }

    @Test
    void isValidateCarName_실패_이름이_blank로만_이루어진_경우() {
        //given
        String input = "   ";
        //when
        Boolean result = inputManager.isValidateCarName(input);
        //then
        assertEquals(false,result);
    }

    @Test
    void isValidateCarName_실패_5자리_이상() {
        //given
        String input = "우아한테크코스";
        //when
        Boolean result = inputManager.isValidateCarName(input);
        //then
        assertEquals(false,result);
    }
}
