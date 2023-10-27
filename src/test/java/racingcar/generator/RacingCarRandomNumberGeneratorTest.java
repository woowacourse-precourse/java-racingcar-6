package racingcar.generator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarRandomNumberGeneratorTest {

    @DisplayName("숫자 생성기에 하나의 숫자가 생성된다.")
    @Test
    void generate() {
        NumberGenerator generator = new RacingCarRandomNumberGenerator();

        Integer randomNumber = generator.generate();

        Assertions.assertThat(randomNumber).isNotNull();
    }
}
