package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarsTest {

    private static final String NAME_EXCEEDS_LENGTH_LIMIT = "longCar";

    @Test
    void 지정한_길이를_초과한_이름의_자동차_생성_시_예외_발생() {
        Assertions.assertThatThrownBy(() -> 자동차들_생성(NAME_EXCEEDS_LENGTH_LIMIT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private Cars 자동차들_생성(String name) {
        String[] carNames = {name};
        return new Cars(carNames);
    }

    private Cars 자동차들_생성(String[] carNames) {
        return new Cars(carNames);
    }
}