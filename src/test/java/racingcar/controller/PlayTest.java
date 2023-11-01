package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayTest {

    private Play play;

    @BeforeEach
    void setUp(){
        play = new Play();
    }

    @Test
    void testVarifyCarNameLength() {
        String[] validNames = {"Car1", "Car2", "Car3"};
        String[] invalidNames = {"Car123", "45Car2"};

        // 유효한 이름 배열 테스트
        play.varifyCarNameLength(validNames);

        // 유효하지 않은 이름 배열 테스트
        assertThrows(IllegalArgumentException.class, ()->play.varifyCarNameLength(invalidNames));

    }

    @Test
    void testVarifyCarNameBlank() {
        String validInput = "Car1,Car2,Car3";
        String invalidInput = "";

        // 유효한 입력 테스트
        play.varifyCarNameBlank(validInput);

        // 유효하지 않은 입력 테스트
        assertThrows(IllegalArgumentException.class, () -> play.varifyCarNameBlank(invalidInput));
    }
    @Test
    void testVarifyTryNumberIsNumeric() {
        String validInput = "5";
        String invalidInput = "abc";

        // 유효한 입력 테스트
        play.varifyTryNumberIsNumeric(validInput);

        // 유효하지 않은 입력 테스트
        assertThrows(IllegalArgumentException.class, () -> play.varifyTryNumberIsNumeric(invalidInput));
    }

    @Test
    void testCreateResultMessage() {
        String carName = "Car1";
        play.racerInformation.put(carName, 3);

        String resultMessage = play.creatResultMessage(new StringBuilder(), carName);
        assertEquals("Car1 : ---", resultMessage);
    }

}
