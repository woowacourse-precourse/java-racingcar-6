package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.constants.Rule.RANDOM_MAX_SIZE;
import static racingcar.model.constants.Rule.RANDOM_MIN_SIZE;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GeneratorTest {
    private Generator generator;
    
    @BeforeEach
    void setUp() {
        generator = new GeneratorImp();
    }

    @ParameterizedTest
    @DisplayName("입력한 크기만큼 램덤 숫자 생성을 테스트 합니다.")
    @ValueSource(ints = { 3, 10, 100 })
    void 랜덤_숫자_리스트_생성_검사(int input) {
        List<Integer> randomNumbers = generator.generateRandomNumbers(input);
        assertThat(randomNumbers).hasSize(input);
    }

    @Test
    @DisplayName("랜덤 숫자가 범위 안에서 생성되는지 테스트 합니다.")
    void 랜덤_숫자_범위_검사() {
        List<Integer> randomNumbers = generator.generateRandomNumbers(1);
        assertThat(randomNumbers.get(0)).isBetween(RANDOM_MIN_SIZE.getValue(), RANDOM_MAX_SIZE.getValue());
    }
}