package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoundTest {

    @Test
    public void createCar_fail_no_round() {
        int zero = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            new Round(zero);
        });
    }

    @Test
    public void createCar_fail_negative_round() {
        int negative = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            new Round(negative);
        });
    }

    @Test
    public void createCar_fail_overflow_round() {
        int overflow = 0x7fffffff + 1;
        assertThrows(IllegalArgumentException.class, () -> {
            new Round(overflow);
        });
    }

}