package racingcar.View;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.junit.jupiter.api.Assertions.*;

class PlayNumberInputTest {
    private static PlayNumberInput playNumberInput;

    @BeforeAll
    public static void setup() {
        playNumberInput = new PlayNumberInput();
    }

    @Test
    void playNumber() {

        System.setIn(new ByteArrayInputStream("42".getBytes()));
        int result = playNumberInput.playNumber();

        assertEquals(42, result);
    }


    @Test
    void notNumberException() {
        final String fake = "five";
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->playNumberInput.notNumberException(fake));

        assertThat(exception.getMessage()).isEqualTo("숫자만 입력 가능합니다.");
    }
}