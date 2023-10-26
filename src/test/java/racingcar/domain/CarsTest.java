package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
        assertThat(cars.getCars().size()).isEqualTo(4);
    }

    @Test
    void Cars_비정상_생성() {
        // given
        String names = "a,bb,ccc,dddddd";

        // when then
        assertThatThrownBy(() -> Cars.from(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Cars_비정상_생성_이름없음() {
        // given
        String nameZero = ", ";

        // when then
        assertThatThrownBy(() -> Cars.from(nameZero))
                .isInstanceOf(IllegalArgumentException.class);

    }
}