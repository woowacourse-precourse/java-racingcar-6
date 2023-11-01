package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {
    private static final List<Integer> NUMBERS = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUP() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    void 범위_내의_정수인지_확인() {
        int result = numberGenerator.createRandomNumber();
        assertThat(result).isIn(NUMBERS);
    }
}