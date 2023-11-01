package racingcar.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @DisplayName("주어진 count 갯수만큼 임의의 숫자를 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "0",
            "9",
            "5",
            "301"
    })
    void generateNotDuplicatedRandomNumbers(int count) {
        // given, when
        List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumbers(count);

        // then
        assertThat(randomNumbers).hasSize(count);
    }

    @DisplayName("count 갯수가 음수이면 임의의 숫자를 반환하지 않는다.")
    @ParameterizedTest
    @CsvSource({
            "-1",
            "-10",
            "-35"
    })
    void generateNotDuplicateddRandomNumbers(int count) {
        // given, when
        List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumbers(count);

        // then
        assertThat(randomNumbers).hasSize(0);
    }

}
