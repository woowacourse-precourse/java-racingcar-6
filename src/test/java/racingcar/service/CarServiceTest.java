package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.utils.constant.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarServiceTest {
    private CarService carService = new CarService();

    @Test
    public void 자동차_리스트_생성() {
        List<Car> cars = carService.createCars(Arrays.asList("car1", "car2"));

        assertThat(cars).hasSize(2);
        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
    }

    @Test
    void 자동차_글자_수_제한() {
        List<String> names = Arrays.asList("longname1", "car2");

        assertThatThrownBy(() -> carService.createCars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.TOO_LONG.getMessage());
    }
}
