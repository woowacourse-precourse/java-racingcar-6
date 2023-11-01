package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.TestCommon;
import racingcar.constants.RandomNumber;

class NumberGeneratorTest extends TestCommon {
    private Integer randomNumber;

    @BeforeEach
    void testInit() {
        randomNumber = NumberGenerator.createRandomSingleNumber();
    }

    @Test
    void 랜덤값_생성_함수가_숫자를_반환하는지_체크한다() {
        assertThat(randomNumber).isInstanceOf(Integer.class);
    }

    @Test
    void 랜덤값의_범위가_0부터_9까지인지_체크한다() {
        Integer rangeMin = RandomNumber.MIN.getValue();
        Integer rangeMax = RandomNumber.MAX.getValue();

        assertThat(randomNumber).isBetween(rangeMin, rangeMax);
    }
}