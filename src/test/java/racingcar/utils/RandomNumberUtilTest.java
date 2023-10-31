package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomNumberUtilTest {
    RandomNumberUtil util = RandomNumberUtil.getInstance();

    @DisplayName("랜덤 숫자 범위 테스트")
    @ParameterizedTest
    @CsvSource({"0,9", "0,1", "0,0", "-1,3"})
    void validateInteger(int minNum, int maxNum) {
        assertThat(util.pickRandomNumber(minNum, maxNum))
                .isBetween(minNum, maxNum);
    }
}