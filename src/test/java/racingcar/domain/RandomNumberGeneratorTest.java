package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @Test
    void generateNumber_메소드_실행시_만들어진_값이_한자리_숫자() {
        //given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int num;

        //when
        num = randomNumberGenerator.generateNumber();
        boolean result = (num >= 0 && num <= 9);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }
}
