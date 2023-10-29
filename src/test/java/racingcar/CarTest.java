package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun", "abcde", "racer", "0123", "%45", "s23", "7df"})
    void ofTest(String input) {
        Car racer = Car.of(input);

        assertThat(racer.name).isEqualTo(input);
    }

    @Test
    void ofExceptionTest() {
        assertThatThrownBy(() -> Car.of("invaildName"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
