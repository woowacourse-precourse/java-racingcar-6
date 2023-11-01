package racingcar.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidTryCountException;

class TryCountTest {

    @Test
    @DisplayName("유효한 입력으로 TryCount를 생성한다.")
    void createTryCountByValidInput() {
        // Given
        String validInput1 = "3";
        String validInput2 = "0";

        // When
        TryCount tryCount1 = TryCount.fromInput(validInput1);
        TryCount tryCount2 = TryCount.fromInput(validInput2);

        // Then
        assertEquals(Integer.valueOf(validInput1), tryCount1.getCount());
        assertEquals(Integer.valueOf(validInput2), tryCount2.getCount());
    }

    @Test
    @DisplayName("숫자가 아닌 입력으로 TryCount 생성 시 InvalidTryCountException을 발생시킨다.")
    void createTryCountByNonNumberInput() {
        // Given
        String nonNumberInput = "abc";

        // When & Then
        assertThrows(InvalidTryCountException.class, () -> TryCount.fromInput(nonNumberInput));
    }

    @Test
    @DisplayName("음수 입력으로 TryCount 생성 시 InvalidTryCountException을 발생시킨다.")
    void createTryCountByNegativeNumberInput() {
        // Given
        String negativeNumberInput = "-3";

        // When & Then
        assertThrows(InvalidTryCountException.class, () -> TryCount.fromInput(negativeNumberInput));
    }
}
