package racingcar.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
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
        Map<String, Integer> carPositions = new LinkedHashMap<>();
        //when
        Boolean result = inputManager.isValidateCarName(input, carPositions);
        //then
        assertEquals(true,result);
    }

    @Test
    void isValidateCarName_실패_이름이_없는_경우() {
        //given
        String input = "";
        Map<String, Integer> carPositions = new LinkedHashMap<>();
        //when
        Boolean result = inputManager.isValidateCarName(input, carPositions);
        //then
        assertEquals(false,result);
    }

    @Test
    void isValidateCarName_실패_이름이_blank로만_이루어진_경우() {
        //given
        String input = "   ";
        Map<String, Integer> carPositions = new LinkedHashMap<>();
        //when
        Boolean result = inputManager.isValidateCarName(input, carPositions);
        //then
        assertEquals(false,result);
    }

    @Test
    void isValidateCarName_실패_5자리_이상() {
        //given
        String input = "우아한테크코스";
        Map<String, Integer> carPositions = new LinkedHashMap<>();
        //when
        Boolean result = inputManager.isValidateCarName(input, carPositions);
        //then
        assertEquals(false,result);
    }

    @Test
    void isValidateCarName_이름이_이미_존재하는_경우() {
        //given
        String input = "pobi";
        Map<String, Integer> carPositions = new LinkedHashMap<>();
        carPositions.put("pobi",0);
        //when
        Boolean result = inputManager.isValidateCarName(input, carPositions);
        //then
        assertEquals(false,result);
    }
}
