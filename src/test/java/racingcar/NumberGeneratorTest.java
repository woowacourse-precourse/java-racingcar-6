package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    void generate_메서드로_범위내의_임의의_수_생성() {
        int result = numberGenerator.generate();

        assertThat(result).isBetween(0, 9);
    }
}