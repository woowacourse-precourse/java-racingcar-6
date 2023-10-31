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
    }

    @DisplayName("각 차 이름의 길이가 알맞은지 확인")
    @Test
    void testCheckNameLength() {
        String[] carNames = {"Car1", "Car2", "Car3456"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                UserInput.checkNameLength(carNames));
        assertEquals(String.format("자동차의 이름을 %s자 이내로 입력해주세요.", NAME_LENGTH), exception.getMessage());
    }
}
