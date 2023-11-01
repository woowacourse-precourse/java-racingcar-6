package racingcar.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {
    private RandomNumber randomNumber;

    @BeforeEach
    void setUp(){
        randomNumber = new RandomNumber();
    }
    private static final int RANDOM_NUMBER_START = 0;
    private static final int RANDOM_NUMBER_FINISH = 9;

    @Test
    void 랜덤_숫자_생성(){
        //given
        int randomNum;

        //when
        randomNum = randomNumber.createRandomNumber();

        //then
        assertThat(randomNum).isLessThanOrEqualTo(RANDOM_NUMBER_FINISH);
        assertThat(randomNum).isGreaterThanOrEqualTo(RANDOM_NUMBER_START);

    }
}