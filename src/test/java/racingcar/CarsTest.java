package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;


public class CarsTest {


    @Test
    void 자동차_이름_테스트() {
        Cars cars = Cars.makeCarList(List.of("car1", "car2"));
        cars.move();
        List<Car> carList = cars.getCarList();
        Car car1 = carList.get(0);
        Car car2 = carList.get(1);
        assertThat(car1.getCarName()).isEqualTo("car1");
        assertThat(car2.getCarName()).isEqualTo("car2");
    }
    @Test
    void cars_이동_테스트() {
        Cars cars = Cars.makeCarList(List.of("car1", "car2","car3","car4"));
        cars.move();
        List<Car> carList = cars.getCarList();
        assertThat(carList.stream().allMatch(car -> car.getPosition() == 1 || car.getPosition() == 0)).isTrue();
    }

    @Test
    void 자동차_이동_테스트() {
        Car car = new Car("car1");
        car.move();
        int position = car.getPosition();
        System.out.println(position);
        assertTrue(position == 1 || position == 0);
    }

    @Test
    void 자동차_위치_문자열_테스트() {
        Cars cars = Cars.makeCarList(List.of("car1", "car2"));
        assertThat(cars.WinnersToString()).isEqualTo("car1, car2");
    }
}
