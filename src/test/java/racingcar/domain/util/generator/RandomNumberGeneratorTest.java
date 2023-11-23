package racingcar.domain.util.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.util.generator.RandomNumberGenerator;

class RandomNumberGeneratorTest {
    @Test
    public void createListNumber_0부터9사이의_숫자_생성() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> result = randomNumberGenerator.createListNumber(3);

        assertThat(result).isNotNull();
        assertThat(result).hasSize(3);
        assertThat(result).allMatch(number -> number >= 0 && number <= 9);
    }
}