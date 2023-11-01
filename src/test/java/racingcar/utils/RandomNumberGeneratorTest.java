package racingcar.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


class RandomNumberGeneratorTest {

    @Test
    public void 한_자리로_이루어진_랜덤_숫자_생성() throws Exception {
        // given
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        int generateNumberInRange = randomNumberGenerator.generateNumberInRange();

        // then
        assertTrue(generateNumberInRange >= 0 && generateNumberInRange <= 9, "0-9 사이의 숫자가 아닙니다!!!");
    }
}