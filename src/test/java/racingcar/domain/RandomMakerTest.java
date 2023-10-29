package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RandomMakerTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void makeRandomNumber(int parameter) {
        assertRandomNumberInRangeTest(() -> {
            assertThat(RandomMaker.makeRandomNumber()).isEqualTo(parameter);
        }, parameter);
    }
}