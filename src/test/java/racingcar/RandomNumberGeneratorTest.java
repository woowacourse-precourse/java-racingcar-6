package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomNumberGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    @DisplayName("주어진 크기만큼 랜덤 값을 생성한다.")
    public void getRandomBySize(int size) {
        List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumbers(size);
        assertThat(randomNumbers).hasSize(size);
    }
}