package racingcar.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomMovingStrategyThresholdTest {
    @ParameterizedTest
    @CsvSource(value = {"0:false", "3:false", "4:true", "5:true", "10:true"}, delimiter = ':')
    void 임계값을_넘는지_조회_시_주어진_숫자가_4_이상이면_true가_반환된다(int randomNumber, boolean expected) {
        RandomMovingStrategyThreshold movingThreshold = RandomMovingStrategyThreshold.from(randomNumber);

        assertThat(movingThreshold.over()).isEqualTo(expected);
    }
}
