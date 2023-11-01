package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MovementPolicyTest {
    private static final int STANDARD_NUMBER = 4;

    @Test
    @DisplayName("성공 : 전진 할 수 있는지 검증")
    void generateRandomNumberForSuccess() {
        // given
        int mockRandomNumber1 = 3;
        int mockRandomNumber2 = 5;

        // when
        boolean goOrNot1 = mockRandomNumber1 >= STANDARD_NUMBER;
        boolean goOrNot2 = mockRandomNumber2 >= STANDARD_NUMBER;

        // then
        assertFalse(goOrNot1);
        assertTrue(goOrNot2);
    }
}
