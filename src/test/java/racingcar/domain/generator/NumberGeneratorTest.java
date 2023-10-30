package racingcar.domain.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    @Test
    public void createListNumber_0부터9사이의_숫자_생성() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> result = numberGenerator.createListNumber(3);

        assertThat(result).isNotNull();
        assertThat(result).hasSize(3);
        assertThat(result).allMatch(number -> number >= 0 && number <= 9);
    }
}