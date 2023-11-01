package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRaceTest {

    @Test
    @DisplayName("precondition 테스트")
    void constructorTest() {
        assertThrows(IllegalArgumentException.class, () -> new CarRace(new String[1], 5));
        assertThrows(IllegalArgumentException.class, () -> new CarRace(new String[]{"123456"}, 5));
        assertThrows(IllegalArgumentException.class, () -> new CarRace(new String[]{"1234"}, -1));

        assertThrows(IllegalArgumentException.class, () -> new CarRace(null, 6));
    }

    @Test
    @DisplayName("경기 결과 테스트")
    void resultTest() {
        List<String> result = new ArrayList<>();
        result.add("123");
        assertEquals(new CarRace(new String[]{"123"}, 1).run(), result);
    }
}
