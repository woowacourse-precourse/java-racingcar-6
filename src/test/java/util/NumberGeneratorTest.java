package racingcar;

import Util.Converter;
import Util.NumberGenerator;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberGeneratorTest {

    @Test
    void 범위_내_난수_생성() {
        final int MIN_RANGE = 0;
        final int MAX_RANGE = 9;

        List<Integer> intList = IntStream.range(MIN_RANGE, MAX_RANGE)
                .boxed()
                .toList();

        Assertions.assertThat(intList.contains(NumberGenerator.createRandomNumber())).isEqualTo(true);
    }

    @Test
    void 범위_밖_난수_생성() {
        final int MIN_RANGE = 10;
        final int MAX_RANGE = 19;

        List<Integer> intList = IntStream.range(MIN_RANGE, MAX_RANGE)
                .boxed()
                .toList();

        Assertions.assertThat(intList.contains(NumberGenerator.createRandomNumber())).isEqualTo(false);
    }
}
