package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

    @DisplayName("시도횟수 입력값이 음수일 경우 실패")
    @Test
    void setAttempts_fail_whenInputValueIsNegativeType() {
        String input = "-3\n";
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Game game = new Game();
        assertThrows(IllegalArgumentException.class, game::setAttempts);
    }
}
