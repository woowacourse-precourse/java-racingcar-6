package racingcar.utils;

import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilsTest {

    @Test
    public void 숫자_0에서_9사이에서_무작위_값을_생성하는_기능_테스트() throws Exception{
        //given
        int startNumber = 1;
        int endNumber = 9;

        //when
        int randomNumber = RandomUtils.generateRandomNumber();

        //then
        assertThat(randomNumber).isGreaterThanOrEqualTo(startNumber).isLessThanOrEqualTo(endNumber);
    }
}
