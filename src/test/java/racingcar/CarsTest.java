package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.ExceptionMessage.INVALID_CAR_NAME_LENGTH;
import static racingcar.TestConstants.MOVING_FORWARD;
import static racingcar.TestConstants.NAME_EXCEEDS_LENGTH_LIMIT;
import static racingcar.TestConstants.NAME_UNDER_LENGTH_LIMIT;
import static racingcar.TestConstants.STOP;

import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 지정한_길이를_초과한_이름의_자동차_생성_시_예외_발생() {
        assertThatThrownBy(() -> 자동차들_생성(NAME_EXCEEDS_LENGTH_LIMIT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CAR_NAME_LENGTH);
    }

    @Test
    void 지정한_길이_이하_길이의_자동차_생성_시_예외가_발생하지_않음() {
        assertThatCode(() -> 자동차들_생성(NAME_UNDER_LENGTH_LIMIT))
                .doesNotThrowAnyException();
    }

    @Test
    void 게임의_진행_결과를_출력한다() {
        String[] carNames = {"love", "hate", "you"};
        String expected = "love : -\nhate : -\nyou : ";
        Cars cars = 자동차들_생성(carNames);
        assertRandomNumberInRangeTest(
                () -> {
                    cars.attempt();
                    assertThat(cars.toString()).isEqualTo(expected);
                }
                , MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자들을_문자열로_반환한다() {
        String[] carNames = {"love", "hate", "you"};
        String expected = "love, hate";
        Cars cars = 자동차들_생성(carNames);
        assertRandomNumberInRangeTest(
                () -> {
                    cars.attempt();
                    assertThat(cars.winners()).isEqualTo(expected);
                }
                , MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    private Cars 자동차들_생성(String name) {
        String[] carNames = {name};
        return new Cars(carNames);
    }

    private Cars 자동차들_생성(String[] carNames) {
        return new Cars(carNames);
    }
}