package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameTest {

    @Test
    void GAME_공백문자처리(){
        Game game = new Game();
        List<String> parsedInput = game.parsingInput("car1,          car2, car3");
        List<String> expected = Arrays.asList("car1", "car2", "car3");
        assertEquals(expected, parsedInput);
    }

    @Test
    void GAME_6글자이상처리(){
        Game game = new Game();
        List<String> parsedInput = game.parsingInput("car1,car2, car3");
        List<String> expected = Arrays.asList("car1", "car2", "car3");
        assertEquals(expected, parsedInput);
    }
    @Test
    void GAME_플레이타임이영어(){
        Game game = new Game();
        String invalidPlayTime = "a";
        assertThrows(IllegalArgumentException.class, () -> game.validateInput(invalidPlayTime));
    }
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3})
    public void GMAE_1보다작은playtime(int invalidPlayTime) {
        Game game = new Game();
        String invalidPlayTimeStr = String.valueOf(invalidPlayTime);
        assertThrows(IllegalArgumentException.class, () -> game.validateInput(invalidPlayTimeStr));
    }
}
