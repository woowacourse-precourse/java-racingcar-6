package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class NumberGeneratorTest {
    @Test
    void testNumberGenerator() {
        NumberGenerator numberGenerator = new NumberGenerator();
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            randomNumbers.add(numberGenerator.createRandomNumber());
        }
        for (int number : randomNumbers) {
            assertThat(number).isGreaterThanOrEqualTo(0).isLessThan(10);
        }
    }
}
