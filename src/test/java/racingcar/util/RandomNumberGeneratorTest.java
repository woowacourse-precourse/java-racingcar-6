package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    @Test
    @DisplayName("넘겨받은 크기의 리스트를 반환하는지 확인")
    public void createRandomNumbers() {
        List<Integer> randomNumbers = RandomNumberGenerator.createRandomNumbers(4);
        assertThat(randomNumbers.size()).isEqualTo(4);
    }

}
