package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EngineTest {

    @Test
    void testGeneratePower() {
        Engine engine = new Engine();
        int power = engine.getPower();
        assertTrue(power >= 0 && power <= 9);
    }

}
