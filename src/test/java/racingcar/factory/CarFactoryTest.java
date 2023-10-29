package racingcar.factory;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {
    CarFactory carFactory = new CarFactory();

    @Test
    void 자동차_이름_개수만큼_자동차_객체를_생성한다() {
        // given
        List<String> carNames = List.of("test1", "test2", "test3");

        // when
        List<Car> cars = carFactory.createCars(carNames);

        // then
        assertThat(cars).hasSize(carNames.size());
    }
}