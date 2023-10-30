package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputValueTest {
    @Test
    void testInputValueMoreThanFiveChars() {
        String input = "pobi,wowni,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class, () -> {
            InputValue inputValue = new InputValue();
        });
    }
    @Test
    void testInputValueFrequency() {
        String input = "pobi,pobi,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class, () -> {
            InputValue inputValue = new InputValue();
        });
    }
}