package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    public void 자동차의_이름은_중복될_수_없다() {
        // given
        String[] carNames = {"pobi, pobi"};

        // when, then
        Assertions.assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

}