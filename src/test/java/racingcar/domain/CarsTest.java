package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class CarsTest {
    @Test
    public void create() {
        // given
        String names = "race,car,coin";

        // when
        Cars cars = new Cars(names);

        // then
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    public void createError() {
        // given
        String names = "race,car,car";

        // when
        // then
        assertThatThrownBy(() -> new Cars(names))
            .isInstanceOf(IllegalArgumentException.class);
    }
}