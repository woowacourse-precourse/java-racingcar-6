package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRaceTest {

    @Test
    @DisplayName("precondition 테스트")
    void constructorTest() {
        String[] name = {"123456"};
        assertThrows(IllegalArgumentException.class, () -> new CarRace(name, 5));
        String[] names = {"1234,5678"};
        assertThrows(IllegalArgumentException.class, () -> new CarRace(names, -1));

        assertThrows(IllegalArgumentException.class, () -> new CarRace(null, 6));
    }

}
