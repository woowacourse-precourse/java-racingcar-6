package racingcar.global.utils.generator;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputNumberOfGamesTest {
    @Test
    public void testValidInput() {
        // given
        InputNumberOfGames inputNumberOfGames = new InputNumberOfGames();
        String input = "4\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when
        Integer result = inputNumberOfGames.getNumberOfGames();

        // then
        Integer expected = 4;
        assertEquals(expected, result);
    }

}