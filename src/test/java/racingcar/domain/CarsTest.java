package racingcar.domain;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("경주에 참여할 자동차들의 정보를 알 수 있다.")
    void createCars() {
        List<Car> source = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        Cars cars = new Cars(source);

        assertThat(cars).extracting("cars", InstanceOfAssertFactories.list(Car.class))
                .containsExactly(new Car("pobi"), new Car("woni"), new Car("jun"));
    }

    @Test
    @DisplayName("경주에 참여할 자동차가 없다면 예외가 발생한다.")
    void invalidCars() {
        assertThatThrownBy(() -> new Cars(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주에 참여할 자동차는 최소 1대 이상이어야 합니다.");
    }
}