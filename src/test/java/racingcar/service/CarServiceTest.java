package racingcar.service;

import racingcar.domain.Car;
import racingcar.utils.constant.message.ErrorMessage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarServiceTest {

    final private CarService carService = new CarService();

    @Test
    void 차량리스트_생성() {
        List<String> names = Arrays.asList("car1", "car2");
        List<Car> cars = carService.createCars(names);

        assertThat(cars).hasSize(2);
        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
    }

    @Test
    void 이름은_5글자_이하여야함() {
        List<String> names = Arrays.asList("car111", "car2");

        assertThatThrownBy(() -> carService.createCars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.TOO_LONG.getMessage());
    }

}