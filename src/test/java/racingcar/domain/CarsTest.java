package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    public void 이름_중복_테스트() {
        // given
        final List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("pobi"));

        // then
        Assertions.assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }
}