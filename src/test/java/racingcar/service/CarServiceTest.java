package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.util.NumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    NumberGenerator dummyGenerator = () -> 0;

    @Test
    @DisplayName("createCars는 자동차 이름 리스트를 받아 자동차 리스트를 반환한다.")
    void createCars() {
        // given
        List<String> carNames = List.of("pobi", "crong", "honux");

        // when
        CarService carService = new CarService(dummyGenerator);
        List<Car> cars = carService.createCars(carNames);

        // then
        assertThat(cars).hasSize(3);

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            String carName = carNames.get(i);

            assertThat(car.getName()).isEqualTo(carName);
        }
    }
}