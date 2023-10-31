package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void testCarConstructZeroChar() {
        assertThatThrownBy(() -> new Car("", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCarConstructSixChar() {
        assertThatThrownBy(() -> new Car("abcdef", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCarConstructNegativeDistance() {
        assertThatThrownBy(() -> new Car("", -1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
