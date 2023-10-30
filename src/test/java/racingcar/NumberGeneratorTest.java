package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {
    @Test
    void 숫자의_범위는_0_9() {
        assertThat(NumberGenerator.generateNumber()).isBetween(0,9);
    }

}
