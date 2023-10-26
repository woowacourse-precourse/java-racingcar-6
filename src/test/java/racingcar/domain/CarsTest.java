package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void Cars_정상_생성() {
        // given
        String names = "a,bb,ccc,dddd";

        // when
        Cars cars = Cars.from(names);

        // then
        Assertions.assertThat(cars.getCars().size()).isEqualTo(4);
    }
}