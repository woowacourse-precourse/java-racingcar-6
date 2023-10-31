package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @Test
    @DisplayName("0에서 9 사이에서 무작위 값을 생성한다")
    void createRandomNumber() {
        int randomNumber = NumberGenerator.createRandomNumber();
        Assertions.assertThat(randomNumber)
                .isGreaterThan(0)
                .isLessThan(9);
    }


}