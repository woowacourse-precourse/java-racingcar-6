package mytest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.UserInput;

public class UserInputTest {
    static final int MIN_NAME_LENGTH = 1;
    static final int MAX_NAME_LENGTH = 5;

    @DisplayName("차 이름을 입력 받고 유효한 값인지 확인")
    @Test
    void testGetCarNames() {
        String[] carNames = {"Car1", "Car2", "Car3"};
        assertDoesNotThrow(() -> UserInput.checkEmpty(carNames));
        assertDoesNotThrow(() -> UserInput.checkNameLength(carNames));
        assertDoesNotThrow(() -> UserInput.checkDuplicates(carNames));
    }

    @DisplayName("차 이름 목록이 비었는지 확인")
    @Test
    void testCheckEmpty() {
        String[] carNames = {};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                UserInput.checkEmpty(carNames));
        assertEquals(String.format("이름을 %d자 이상, %d자 이내로 입력해주세요.", MIN_NAME_LENGTH, MAX_NAME_LENGTH),
                exception.getMessage());
    }

    @DisplayName("차 이름이 최소 길이보다 짧은지 확인")
    @Test
    void testCheckNameLength_shortName() {
        String[] carNames = {"Car1", "Car2", ""};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                UserInput.checkNameLength(carNames));
        assertEquals(String.format("이름을 %d자 이상 입력해주세요.", MIN_NAME_LENGTH), exception.getMessage());
    }

    @DisplayName("차 이름이 최대 길이보다 긴지 확인")
    @Test
    void testCheckNameLength_longName() {
        String[] carNames = {"Car1", "Car2", "Car3456"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                UserInput.checkNameLength(carNames));
        assertEquals(String.format("이름을 %s자 이내로 입력해주세요.", MAX_NAME_LENGTH), exception.getMessage());
    }

    @DisplayName("차 이름 중 중복된 값이 있는지 확인")
    @Test
    void testCheckDuplicates() {
        String[] carNames = {"Car1", "Car2", "Car1"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                UserInput.checkDuplicates(carNames));
        assertEquals("이름을 중복되지 않게 입력해주세요.", exception.getMessage());
    }

    @DisplayName("진행할 라운드 값을 입력 받고 유효한지 확인")
    @Test
    void testGetTotalRound() {
        String inputRaceCount = "5";
        assertDoesNotThrow(() -> UserInput.checkInteger(inputRaceCount));
        int raceCount = UserInput.checkInteger(inputRaceCount);
        assertDoesNotThrow(() -> UserInput.checkPositiveInteger(raceCount));
    }

    @DisplayName("입력 받은 값이 숫자인지 확인")
    @Test
    void testCheckInteger() {
        String inputRaceCount = "다섯";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                UserInput.checkInteger(inputRaceCount));
        assertEquals("숫자만 입력해주세요.", exception.getMessage());
    }

    @DisplayName("입력 받은 값이 양의 정수인지 확인")
    @Test
    void testCheckPositiveInteger() {
        int raceCount = -1;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                UserInput.checkPositiveInteger(raceCount));
        assertEquals("양의 정수만 입력해주세요.", exception.getMessage());
    }
}
