package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PositionTest {
    private static final int INITIAL_POSITION = 0;

    private static final int INCREASED_POSITION = 1;

    @Test
    void create() {
        Position position = new Position();
        assertEquals(position.getValue(), INITIAL_POSITION);
    }

    @Test
    void increase() {
        Position position = new Position();
        position.increase();
        assertEquals(position.getValue(), INCREASED_POSITION);
    }
}
