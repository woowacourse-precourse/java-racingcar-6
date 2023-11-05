package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.config.GameConfig;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.config.GameConfig.*;

@DisplayName("RandomUtilTest")
class RandomUtilTest {

    @Test
    @DisplayName("정해진 범위의 랜덤한 숫자를 반환한다.")
    void getRandomNumber() {
        //given
        int start = RANDOM_NUMBER_RANGE_START.getNumber();
        int end = RANDOM_NUMBER_RANGE_END.getNumber();

        //when
        int randomNumber = RandomUtil.getRandomNumber();

        //then
        assertThat(randomNumber).isGreaterThanOrEqualTo(start).isLessThanOrEqualTo(end);
    }
}