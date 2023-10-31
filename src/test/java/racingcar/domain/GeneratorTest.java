package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class GeneratorTest {
    private static final int CAR_NUMBER = 3;

    @Test
    void 난수_개수() {
        Generator generator = new Generator();
        List<Integer> result = generator.createRandomNumbers(CAR_NUMBER);
        assertThat(result.size()).isEqualTo(CAR_NUMBER);
    }
}