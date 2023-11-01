package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameNumberGeneratorTest {
    private final NumberGenerator numberGenerator = new GameNumberGenerator();

    @Test
    public void getNumber() {
        int randomNumber = numberGenerator.randomNumber();

        Assertions.assertThat(randomNumber).isLessThan(10).isGreaterThan(-1);
    }

}