package racingcar.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


class RandomNumberGeneratorTest {

    @Test
    public void 랜덤_숫자_생성() throws Exception {
        // given
        NumberGenerator generator = new RandomNumberGenerator();

        // when
        int number = generator.generateNumberInRange();

        // then
        assertTrue(number >= 0 && number <= 9, "0-9 사이의 숫자가 아닙니다!!!");
    }

}