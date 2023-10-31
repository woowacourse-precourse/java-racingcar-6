package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarControllerTest {

    @Test
    public void 초기_자동차_이름_위치_테스트() throws Exception {
        //given
        CarController carController = new CarController();
        List<String> carNames = Arrays.asList("car1", "car2", "car3");

        //when
        List<Car> cars = carController.initializeCars(carNames);

        //then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
        assertThat(cars.get(2).getName()).isEqualTo("car3");
        assertThat(cars.get(0).getPosition()).isEqualTo(0);
        assertThat(cars.get(1).getPosition()).isEqualTo(0);
        assertThat(cars.get(2).getPosition()).isEqualTo(0);
    }

}