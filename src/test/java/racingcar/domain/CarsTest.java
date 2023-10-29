package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars cars = new Cars();

    @Test
    void 자동차_추가() {
        // given
        Car car = new Car("pobi");

        // when
        cars.addCar(car);
        List<Car> carList = cars.getCars();

        // then
        assertThat(carList.get(0).getName()).isEqualTo(car.getName());
    }
}
