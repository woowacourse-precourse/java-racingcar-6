package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class NumberGeneratorTest {

    @Test
    void randomNumber_범위_내_난수_생성() {
        final NumberGenerator numberGenerator = new NumberGenerator(0, 9);
        final int MIN_RANGE = 0;
        final int MAX_RANGE = 9;

        List<Integer> intList = IntStream.range(MIN_RANGE, MAX_RANGE)
                .boxed()
                .toList();

        Assertions.assertThat(intList.contains(numberGenerator.randomNumber())).isEqualTo(true);
    }

    @Test
    void randomNumber_범위_밖_난수_생성() {
        final NumberGenerator numberGenerator = new NumberGenerator(0, 9);
        final int MIN_RANGE = 10;
        final int MAX_RANGE = 19;

        List<Integer> intList = IntStream.range(MIN_RANGE, MAX_RANGE)
                .boxed()
                .toList();

        Assertions.assertThat(intList.contains(numberGenerator.randomNumber())).isEqualTo(false);
    }
}
