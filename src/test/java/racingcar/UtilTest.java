package racingcar;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UtilTest {

    @Test
    void 공백을_지운다() {
        String carNames = "pobi,  woni,     jun";
        String result = Util.trim(carNames);
        String expected = "pobi,woni,jun";
        assertEquals(expected, result);
    }
}