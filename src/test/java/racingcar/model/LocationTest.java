package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocationTest {

    private Location location;

    @BeforeEach
    public void setUp() {
        location = Location.init();
    }

    @Test
    public void 위치_이동시_랜덤한_값에_따라_0_혹은_1씩_움직인다() {
        Location moved = location.move();
        assertTrue(moved.location() == 0 || moved.location() == 1);
    }
}