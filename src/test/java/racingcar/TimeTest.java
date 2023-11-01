package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeTest {
    Time time = new Time();

    @Test
    @DisplayName("숫자가 아닌 문자가 입력된 경우 예외 확인")
    void testZero() {
        String input = "1.3";
        assertThrows(IllegalArgumentException.class, () ->
                time.inputTime(input));
    }

    @Test
    @DisplayName("음수가 입력된 경우 예외 확인")
    void testNegative() {
        String input = "-6";
        assertThrows(IllegalArgumentException.class, () ->
                time.inputTime(input));
    }
}
