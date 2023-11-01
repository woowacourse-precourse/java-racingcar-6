package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    private static final int CRITICAL_OF_MOVING = 4;

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun", "abcde", "racer", "0123", "%45", "s23", "7df"})
    void ofTest(String input) {
        Car racer = Car.of(input);

        assertThat(racer.getName()).isEqualTo(input);
    }

    @Test
    void ofExceptionTest() {
        assertThatThrownBy(() -> Car.of("invaildName"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "4"})
    void moveOrStayTest(String input) {
        int randomNumber = Integer.parseInt(input);
        Car racer = Car.of("pobi");

        racer.moveOrStay(randomNumber);

        if (randomNumber < CRITICAL_OF_MOVING) {
            assertThat(racer.getDistance()).isEqualTo(0);
        } else {
            assertThat(racer.getDistance()).isEqualTo(1);
        }
    }
}
