package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomUtilsTest {

    @DisplayName("주어진 범위 내에 있는 숫자를 뽑는다.")
    @ParameterizedTest(name = "[{index}차]시도: minimumValue: {0}, maximumValue: {1}")
    @CsvSource({"1,2", "2,3", "2,2", "1,1", "1,100"})
    void testGetRandomNumber(int minimumValue, int maximumValue) {
        //given
        //when
        int randomNumber = RandomUtils.getRandomNumber(minimumValue, maximumValue);
        //then
        assertThat(randomNumber).isGreaterThanOrEqualTo(minimumValue).isLessThanOrEqualTo(maximumValue);
    }

}