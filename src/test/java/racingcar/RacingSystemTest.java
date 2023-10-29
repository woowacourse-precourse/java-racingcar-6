package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingSystemTest {

    @Test
    void 중복_예외발생() {
        RacingSystem racingSystem = new RacingSystem();
        assertThrows(IllegalArgumentException.class,
                () -> racingSystem.checkValid("car1, car2, car1"));
    }

    @Test
    void 길이_초과_예외발생() {
        RacingSystem racingSystem = new RacingSystem();
        assertThrows(IllegalArgumentException.class,
                () -> racingSystem.checkValid("car123, car2, "));
    }

    @Test
    void 공백_예외_처리() {
        RacingSystem racingSystem = new RacingSystem();
        assertThrows(IllegalArgumentException.class,
                () -> racingSystem.checkValid("car1, car2, "));
    }
}