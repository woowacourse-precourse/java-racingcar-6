package racingcar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;


class InputHandlerTest {
    @Test
    void validCarNames() {
        String input = "pobi,woni,jun";
        assertDoesNotThrow(() -> InputHandler.validateCarNames(input));
    }

    @Test
    void invalidCarNames() {
        String input = "longname,pobi";
        assertThrows(IllegalArgumentException.class, () -> InputHandler.validateCarNames(input));
    }

    @Test
    void getTryCount_ValidInput() {
        // Arrange
        String input = "5\n"; // 사용자가 입력할 것으로 예상되는 문자열
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Act
        int tryCount = InputHandler.getTryCount();

        // Assert
        assertEquals(5, tryCount);
    }

    @Test
    void getTryCount_InvalidInput() {
        // Arrange
        String input = "invalid\n"; // 사용자가 숫자 대신 문자열을 입력함
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, InputHandler::getTryCount);
    }
}
