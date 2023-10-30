package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberGeneratorTest {

    @Test
    void createRandomNumberTest() {
        NumberGenerator numberGenerator = new NumberGenerator();
        int randomNumber = numberGenerator.createRandomNumber();

        assertThat(randomNumber).isBetween(0, 9);
    }
}
