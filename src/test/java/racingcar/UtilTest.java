package racingcar;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UtilTest {

    String carNames;

    @BeforeEach
    void init() {
        carNames = "supra,  gr86,   GTR";
    }

    @Test
    void 공백을_지운다() {
        String result = Util.trim(carNames);
        String expected = "supra,gr86,GTR";
        assertEquals(expected, result);
    }

    @Test
    void 배열에_이름을_담는다() {
        List<String> actual = Util.toList(carNames);
        List<String> expected = Arrays.asList("supra", "gr86", "GTR");
        assertEquals(expected, actual);
    }

}