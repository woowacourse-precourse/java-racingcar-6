package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarFactoryTest {

    @Test
    public void 자동차_변환_테스트() {
        // given
        List<String> namesOfCars = List.of("pobi", "woni");

        // when
        List<Car> cars = CarFactory.generateCar(namesOfCars);

        // then
        Assertions.assertThat(cars).hasSize(2);
    }
}