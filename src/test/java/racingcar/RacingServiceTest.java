package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingServiceTest {

    @DisplayName("자동차가 1회 움직이면 위치는 1 이다.")
    @Test
    void moveSuccessTest() {
        Car car = new Car("car");
        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("움직이지 않으면 위치는 0 이다.")
    @Test
    void moveFailTest() {
        Car car = new Car("car");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("우승자가 1명만 있는 경우 리스트에는 한 명만 있다.")
    @Test
    void getSingleWinnerTest() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.moveForward();
        List<Car> carList = List.of(car1, car2, car3);
        Cars cars = new Cars(carList);
        List<Car> winner = cars.getWinnerList();

        assertThat(winner).containsExactly(car1);
    }

    @DisplayName("우승자가 2명이 있는 경우 리스트에는 2명만 있다.")
    @Test
    void getDoubleWinnerTest() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.moveForward();
        car2.moveForward();
        List<Car> carList = List.of(car1, car2, car3);
        Cars cars = new Cars(carList);
        List<Car> winner = cars.getWinnerList();

        assertThat(winner).containsExactly(car1, car2);
    }
}
