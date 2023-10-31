package mytest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.UserInput;

public class UserInputTest {
    static final int NAME_LENGTH = 5;

    @DisplayName("차 이름을 입력 받고 유효한 값인지 확인")
    @Test
    void testGetCarNames() {
        String[] carNames = {"Car1", "Car2", "Car3"};
        assertDoesNotThrow(() -> UserInput.checkNameLength(carNames));
        assertDoesNotThrow(() -> UserInput.checkDuplicates(carNames));
    }

    @DisplayName("각 차 이름의 길이가 알맞은지 확인")
    @Test
    void testCheckNameLength() {
        String[] carNames = {"Car1", "Car2", "Car3456"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                UserInput.checkNameLength(carNames));
        assertEquals(String.format("자동차의 이름을 %s자 이내로 입력해주세요.", NAME_LENGTH), exception.getMessage());
    }

    @DisplayName("차 이름 중 중복된 값이 있는지 확인")
    @Test
    void testCheckDuplicates() {
        String[] carNames = {"Car1", "Car2", "Car1"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                UserInput.checkDuplicates(carNames));
        assertEquals("자동차의 이름을 중복되지 않게 입력해주세요.", exception.getMessage());
    }

    @DisplayName("진행할 라운드 값을 입력 받고 유효한지 확인")
    @Test
    void testGetTotalRound() {
        String inputRaceCount = "5";
        assertDoesNotThrow(() -> UserInput.checkInteger(inputRaceCount));
    }

    @DisplayName("입력 받은 값이 숫자인지 확인")
    @Test
    void testCheckInteger() {
        String inputRaceCount = "다섯";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                UserInput.checkInteger(inputRaceCount));
        assertEquals("숫자만 입력해주세요.", exception.getMessage());
    }
}
