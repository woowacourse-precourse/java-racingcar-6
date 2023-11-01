package racingcar.domain.random;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.RacingGameConstant.RANDOM_NUMBER_END_INCLUSIVE;
import static racingcar.constant.RacingGameConstant.RANDOM_NUMBER_START_INCLUSIVE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomNumberFactoryTest {

    @ParameterizedTest
    @DisplayName("0 ~ 9 사이의 랜덤 값을 만든다.")
    @ValueSource(ints = {0, 9})
    void createRandomNumberRangeZeroToNine(int given) {
        // given
        RandomNumberFactory randomNumberFactory = new RandomNumberFactory(new DoubleRandomService(given));

        // when
        int result = randomNumberFactory.create(RANDOM_NUMBER_START_INCLUSIVE, RANDOM_NUMBER_END_INCLUSIVE);

        // then
        assertThat(result).isEqualTo(given);
    }
}
