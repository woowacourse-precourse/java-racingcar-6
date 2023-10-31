package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.constants.RandomNumber;

class NumberGeneratorTest {
    private final NumberGenerator generator = new NumberGenerator();

    @Test
    void 랜덤값_생성_함수가_숫자를_반환하는지_체크한다() {
        assertThat(generator.createRandomSingleNumber()).isInstanceOf(Integer.class);
    }

    @Test
    void 랜덤값의_범위가_0부터_9까지인지_체크한다() {
        Integer randomNumber = generator.createRandomSingleNumber();
        Integer rangeMin = RandomNumber.MIN.getValue();
        Integer rangeMax = RandomNumber.MAX.getValue();

        assertThat(randomNumber).isBetween(rangeMin, rangeMax);
    }
}