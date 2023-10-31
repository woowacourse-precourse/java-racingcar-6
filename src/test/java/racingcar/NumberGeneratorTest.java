package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @Test
    void 랜덤_수_범위_확인() {
        NumberGenerator numberGenerator = new NumberGenerator();
        int randomNumber = numberGenerator.makeRandomNumber();
        assertThat(randomNumber).isGreaterThan(0).isLessThan(10);
    }
}