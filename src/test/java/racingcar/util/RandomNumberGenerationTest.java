package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGenerationTest {

    @DisplayName("랜덤 숫자 생성 테스")
    @Test
    void generator() {

        //given
        RandomNumberGenerator generator = new RandomNumberGenerator();

        //when
        List<Integer> randomNumbers = IntStream.range(0, 100)
                .mapToObj(i -> generator.generate())
                .collect(Collectors.toList());

        //then
        assertThat(randomNumbers.stream().allMatch(v -> v >= 0 && v <= 9)).isTrue();
    }
}
