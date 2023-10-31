package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.AppConfig;
import racingcar.domain.Car;

public class CarServiceTest {

    AppConfig appConfig = new AppConfig();
    CarService carService = appConfig.carService();

    @Test
    void car_저장_테스트() {
        //given
        Car car = new Car("paek", 1L);

        //when
        carService.join(car);
        Car savedCar = carService.findCarById(1L);

        //then
        Assertions.assertThat(car).isEqualTo(savedCar);
    }

    @Test
    void car_여러개_저장_테스트() {
        List<Car> list = new ArrayList<>();
        //given
        Car car1 = new Car("paek1", 1L);
        Car car2 = new Car("paek2", 2L);
        //when
        carService.join(car1);
        list.add(car1);
        carService.join(car2);
        list.add(car2);
        List<Car> savedlist = carService.findAllCars();

        //then
        Assertions.assertThat(list.get(0)).isEqualTo(savedlist.get(0));
        Assertions.assertThat(list.get(1)).isEqualTo(savedlist.get(1));
    }
}
