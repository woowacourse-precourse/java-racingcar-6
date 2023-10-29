package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumbersGeneratorTest {

    @Test
    @DisplayName("전달하는 size에 맞게 생성이 되는지 테스트")
    void generateRandomNumberSizeTest() {
        List<Integer> generate = RandomNumbersGenerator.generate(3);
        assertThat(generate.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("생성되는 숫자가 범위 이내에서 생성되는지 테스트")
    void testGenerateProducesNumbersWithinRange() {
        int limitSize = 100;

        List<Integer> generatedNumbers = RandomNumbersGenerator.generate(limitSize);

        assertThat(generatedNumbers)
                .allMatch(num -> num >= RandomNumbersGenerator.MIN && num <= RandomNumbersGenerator.MAX);
    }
}